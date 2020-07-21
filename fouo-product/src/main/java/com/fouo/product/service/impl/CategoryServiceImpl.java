package com.fouo.product.service.impl;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.utils.Func;
import com.fouo.product.entity.Category;
import com.fouo.product.service.ICategoryBrandRelationService;
import com.fouo.product.vo.CategoryVO;
import com.fouo.product.mapper.CategoryMapper;
import com.fouo.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private ICategoryBrandRelationService categoryBrandRelationService;
    @Override
    public IPage<CategoryVO> selectCategoryPage(IPage<CategoryVO> page, CategoryVO category) {
        return page.setRecords(baseMapper.selectCategoryPage(page, category));
    }

    @Override
    public IPage<Category> listWithTree(Category category, Query query) {
        //获取所有根据查询条件获取的所有商品列表
        IPage<Category> page = page(Condition.getPage(query), Condition.getQueryWrapper(category));
        List<Category> entities = page.getRecords();

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

    @Override
    public boolean updateDetail(Category category) {
        //保证冗余字段的数据一致
        boolean flag = updateById(category);
        if(StringUtils.isNotBlank(category.getName())){
            //同步更新其他关联表中的数据
            categoryBrandRelationService.updateCategoryNameByCategoryId(category.getCatId(),category.getName());
        }
        return flag;
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

}
