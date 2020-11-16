package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.utils.Func;
import com.fouo.product.entity.Category;
import com.fouo.product.service.ICategoryBrandRelationService;
import com.fouo.product.vo.Catalog2VO;
import com.fouo.product.vo.Catalog3VO;
import com.fouo.product.vo.CategoryVO;
import com.fouo.product.mapper.CategoryMapper;
import com.fouo.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 商品三级分类 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ICategoryBrandRelationService categoryBrandRelationService;

    @Override
    public IPage<CategoryVO> selectCategoryPage(IPage<CategoryVO> page, CategoryVO category) {
        return page.setRecords(baseMapper.selectCategoryPage(page, category));
    }

    @Override
    public IPage<Category> listWithTree(Category category, Query query) {
        //获取所有根据查询条件获取的所有商品列表
        IPage<Category> page = page(Condition.getPage(query), Condition.getQueryWrapper(category));
        List<Category> entities = baseMapper.selectList(null);
//        List<Category> entities = page.getRecords();

        //组成父子树形结构
        List<Category> childrenList = entities.stream().
                //获取所有一级子菜单
                        filter(categoryEntity -> categoryEntity.getParentCid() == 0).
                        map(menu -> {
                            menu.setChildren(getChildrens(menu, entities));
                            return menu;
                        }).
                        sorted((menu1, menu2) ->
                                (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort())
                        ).
                        collect(Collectors.toList());
        return page.setRecords(childrenList);
    }

    @Override
    public boolean removeMenu(List<Long> ids) {
        //TODO 1、检查当前删除的菜单，是否被别的地方引用
        return removeByIds(ids);
    }

    @Override
    public Long[] searchCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();

        paths = findParentPath(catelogId, paths);
        Collections.reverse(paths);
        return paths.toArray(new Long[paths.size()]);
    }

    /**
     * @param category
     * @return
     * @CacheEvict 失效模式 修改数据之后 将缓存清空  再查询的时候再次添加完整的缓存
     * 清除多个缓存
     */

//    @Caching(evict = {
//            @CacheEvict(value = {"category"}, key = "getTopCategory"),
//            @CacheEvict(value = {"category"}, key = "getCatalogJson")
//    })
    @CacheEvict(value = "category",allEntries = true)
    @Transactional
    @Override
    public boolean updateDetail(Category category) {
        //保证冗余字段的数据一致
        boolean flag = updateById(category);
        if (StringUtils.isNotBlank(category.getName())) {
            //同步更新其他关联表中的数据
            categoryBrandRelationService.updateCategoryNameByCategoryId(category.getCatId(), category.getName());
        }
        return flag;
    }

    //每一个需要缓存的数据都来指定要放到哪个名字的缓存中【缓存的分区】 按照业务类型分
    //在查询的时候  设置 sync=true  会调用 具有锁的get方法 则会解决 缓存击穿的问题
    @Cacheable(value = {"category"/*,"product"*/}, key = "#root.method.name",sync = true)
    //代表当前方法的结果需要缓存，如果缓存中有，则方法不需要调用。如果缓存中没有，则需要调用缓存，并将结果存入到缓存中去
    @Override
    public List<Category> getTopCategory() {
        List<Category> categorys = baseMapper.selectList(new QueryWrapper<Category>().eq("parent_cid", 0));
        return categorys;
    }


    @Cacheable(value = {"category"}, key = "#root.methodName",sync = true)
    @Override
    public Map<String, List<Catalog2VO>> getCatalogJson() {
        List<Category> categories = baseMapper.selectList(null);
        //查询所有1级分类
        List<Category> topCategory = getParentCid(categories, 0L);
        //封装数据
        Map<String, List<Catalog2VO>> map = topCategory.stream().collect(Collectors.toMap(k -> {
                    return k.getCatId().toString();
                },
                v -> {
                    //查出当前分类(一级)的二级分类
                    List<Category> secondList = getParentCid(categories, v.getCatId());
                    //二级分类非空时
                    List<Catalog2VO> catalog2VOS = null;
                    if (secondList != null && secondList.size() > 0) {
                        catalog2VOS = secondList.stream().map(item -> {
                            //创建二级分类VO
                            Catalog2VO catalog2VO = new Catalog2VO();
                            catalog2VO.setCatalog1Id(v.getCatId().toString());
                            catalog2VO.setId(item.getCatId().toString());
                            catalog2VO.setName(item.getName());

                            List<Catalog3VO> collect = null;
                            List<Category> thirdList = getParentCid(categories, item.getCatId());
                            if (thirdList != null && thirdList.size() > 0) {
                                collect = thirdList.stream().map(entity -> {
                                    Catalog3VO catalog3VO = new Catalog3VO();
                                    catalog3VO.setCatalog2Id(item.getCatId().toString());
                                    catalog3VO.setId(entity.getCatId().toString());
                                    catalog3VO.setName(entity.getName().toString());
                                    return catalog3VO;
                                }).collect(Collectors.toList());
                            }

                            catalog2VO.setCatalog3List(collect);
                            return catalog2VO;

                        }).collect(Collectors.toList());
                    }
                    return catalog2VOS;
                }));
        return map;
    }

    public Map<String, List<Catalog2VO>> getCatalogJson2() {
        Gson gson = new Gson();
        /**
         * 缓存穿透 - 大并发强行查询一个不存在的缓存  导致大并发请求都不经过缓存 直接查询数据库 导致数据库失效（给空值添加缓存 设置短暂存活时间）
         * 缓存雪崩 - 缓存大面积同时失效 遇见大并发时  依旧大并发下查询数据库  导致数据库崩溃 （ 给缓存设置不同给的过期时间）
         * 缓存击穿 - 对于某一个热点key  进行大并发查询 ，当该key缓存失效时 依旧会全部查询数据库导致数据库崩溃 （加一个锁  让第一个请求查询库 添加缓存  后续并发请求 重新查询缓存）
         *
         *1,空结果缓存: 解决缓存穿透
         *2,设置过期时间（加随机值）：解决缓存雪崩
         *3,加锁：解决缓存击穿问题
         *
         * 注意 在释放锁之前要 先将缓存先添加 进redis  这是一个原子操作 （锁的时序问题）
         *
         */
        //缓存中存储的是一个json字符串,便于跨平台兼容
        String json = redisTemplate.boundValueOps("catalogJson").get();

        //当缓存中不存在json数据时
        if (StringUtils.isBlank(json)) {
            //从数据库中查询json
            Map<String, List<Catalog2VO>> map = getCatalogJsonFromDBWithRedissonLock();
            return map;
        }

        Map<String, List<Catalog2VO>> map = gson.fromJson(json, new TypeToken<Map<String, List<Catalog2VO>>>() {
        }.getType());
        return map;
    }

    /**
     * 从数据库查询并封装分类数据
     * 采用分布式锁的形式
     * 使用redisson
     * <p>
     * 缓存里面的数据如何和数据库保持一致
     * 缓存数据一致性
     * <p>
     * 1.双写模式
     * 2.失效模式
     *
     * @return
     */
    public Map<String, List<Catalog2VO>> getCatalogJsonFromDBWithRedissonLock() {
        Gson gson = new Gson();
        //获取分布式锁
        RLock lock = redissonClient.getLock("CatalogJson-lock");
        lock.lock(30, TimeUnit.SECONDS);
        Map<String, List<Catalog2VO>> dataFromDB;
        try {
            dataFromDB = getDataFromDB(gson);
        } finally {
            lock.unlock();
        }
        return dataFromDB;
    }

    /**
     * 从数据库查询并封装分类数据
     * 采用分布式锁的形式
     *
     * @return
     */
    public Map<String, List<Catalog2VO>> getCatalogJsonFromDBWithRedisLock() {
        Gson gson = new Gson();
        String uuid = UUID.randomUUID().toString();
        //加锁（redis的分布式锁）
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 300, TimeUnit.SECONDS);
        if (lock) {
            Map<String, List<Catalog2VO>> dataFromDB;
            //加锁成功..设置锁过期时间 ...执行业务
//            redisTemplate.expire("lock", 30, TimeUnit.SECONDS);//30s后这个lock锁过期，自动销毁   但是需要具有原子性
            try {
                dataFromDB = getDataFromDB(gson);
            } finally {
                String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
                //删除锁
                redisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList("lock"), uuid);
            }

//            //执行成功后 释放锁 为了保证原子性 则需要使用lua脚本
//            String lockValue = redisTemplate.boundValueOps("lock").get();
//            if(uuid.equals(lockValue)){
//                //删除自己的锁
//                redisTemplate.delete("lock");
//            }
            return dataFromDB;
        } else {
            //加锁失败..重试  采用自旋的方式
            //休眠100毫秒
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getCatalogJsonFromDBWithRedisLock();
        }
    }


    /**
     * 从数据库查询并封装分类数据
     *
     * @return
     */
    public Map<String, List<Catalog2VO>> getCatalogJsonFromDB() {
        Gson gson = new Gson();
        return getDataFromDB(gson);
    }

    private List<Category> getParentCid(List<Category> categories, Long parentCid) {
//        return baseMapper.selectList(new QueryWrapper<Category>().eq("parent_cid", v.getCatId()));
        List<Category> collect = categories.stream().filter(item -> {
            return item.getParentCid().equals(parentCid);
        }).collect(Collectors.toList());
        return collect;
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        //根据分类id获取分类对象
        Category category = getById(catelogId);
        //收集当前节点id
        paths.add(catelogId);

        if (category.getParentCid() != 0) {
            findParentPath(category.getParentCid(), paths);
        }
        return paths;
    }


    /**
     * 递归设置子菜单
     *
     * @param root
     * @param all
     * @return
     */
    private List<Category> getChildrens(Category root, List<Category> all) {
        List<Category> children = all.stream().
                //过滤出所有菜单中，是当前菜单的子菜单的列表。（列表中的对象的父id和当前对象id相等）
                        filter(entity -> entity.getParentCid().equals(root.getCatId())).
                        map(entity -> {
                            //继续递归调用子菜单进行设置其2级子菜单
                            entity.setChildren(getChildrens(entity, all));
                            return entity;
                        }).
                        sorted((menu1, menu2) ->
                                (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort())
                        ).
                        collect(Collectors.toList());
        return children;
    }


    private Map<String, List<Catalog2VO>> getDataFromDB(Gson gson) {
        /**
         * 第一种优化
         */
        List<Category> categories = baseMapper.selectList(null);
        //查询所有1级分类
        List<Category> topCategory = getParentCid(categories, 0L);
        //封装数据
        Map<String, List<Catalog2VO>> map = topCategory.stream().collect(Collectors.toMap(k -> {
                    return k.getCatId().toString();
                },
                v -> {
                    //查出当前分类(一级)的二级分类
                    List<Category> secondList = getParentCid(categories, v.getCatId());
                    //二级分类非空时
                    List<Catalog2VO> catalog2VOS = null;
                    if (secondList != null && secondList.size() > 0) {
                        catalog2VOS = secondList.stream().map(item -> {
                            //创建二级分类VO
                            Catalog2VO catalog2VO = new Catalog2VO();
                            catalog2VO.setCatalog1Id(v.getCatId().toString());
                            catalog2VO.setId(item.getCatId().toString());
                            catalog2VO.setName(item.getName());

                            List<Catalog3VO> collect = null;
                            List<Category> thirdList = getParentCid(categories, item.getCatId());
                            if (thirdList != null && thirdList.size() > 0) {
                                collect = thirdList.stream().map(entity -> {
                                    Catalog3VO catalog3VO = new Catalog3VO();
                                    catalog3VO.setCatalog2Id(item.getCatId().toString());
                                    catalog3VO.setId(entity.getCatId().toString());
                                    catalog3VO.setName(entity.getName().toString());
                                    return catalog3VO;
                                }).collect(Collectors.toList());
                            }

                            catalog2VO.setCatalog3List(collect);
                            return catalog2VO;

                        }).collect(Collectors.toList());
                    }
                    return catalog2VOS;
                }));

        //重新添加缓存 （在还没释放锁的时候将结果存放到缓存中去）
        redisTemplate.boundValueOps("catalogJson").set(gson.toJson(map));
        return map;
    }
}
