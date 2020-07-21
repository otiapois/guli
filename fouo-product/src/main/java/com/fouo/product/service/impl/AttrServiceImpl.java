package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectBatchByIds;
import com.fouo.common.support.Condition;
import com.fouo.product.entity.Attr;
import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.entity.Category;
import com.fouo.product.mapper.AttrAttrgroupRelationMapper;
import com.fouo.product.mapper.AttrGroupMapper;
import com.fouo.product.mapper.CategoryMapper;
import com.fouo.product.service.ICategoryService;
import com.fouo.product.vo.AttrVO;
import com.fouo.product.mapper.AttrMapper;
import com.fouo.product.service.IAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.vo.BrandVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

    @Autowired
    private AttrAttrgroupRelationMapper attrAttrgroupRelationMapper;
    @Autowired
    private AttrGroupMapper attrGroupMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ICategoryService categoryService;


    @Override
    public IPage<AttrVO> selectAttrPage(IPage<AttrVO> page, AttrVO attrVO) {
        List<Attr> list = baseMapper.selectAttrPage(page, attrVO);
        List<AttrVO> collect = list.stream().map(entity -> {
            AttrVO attrVo = new AttrVO();
            BeanUtils.copyProperties(entity, attrVo);
            return attrVo;
        }).collect(Collectors.toList());
        return page.setRecords(collect);
    }

    @Transactional
    @Override
    public boolean saveAttr(AttrVO attrVO) {
        //保存属性的基本信息
        save(attrVO);

        //保存属性和分组id的关联关系
        AttrAttrgroupRelation relation = new AttrAttrgroupRelation();

        if (attrVO.getAttrType() == 1) {
            relation.setAttrGroupId(attrVO.getAttrGroupId());
            relation.setAttrId(attrVO.getAttrId());
            //保存关联关系
            attrAttrgroupRelationMapper.insert(relation);
        }
        return true;
    }

    @Override
    public IPage<AttrVO> selectBaseAttrPage(IPage<AttrVO> page, AttrVO attrVO) {
        List<Attr> list = baseMapper.selectBaseAttrPage(page, attrVO);

        List<AttrVO> collect = list.stream().map((entity -> {
            AttrVO attrVo = new AttrVO();
            BeanUtils.copyProperties(entity, attrVo);

            if (attrVo.getAttrId() != null) {
                //根据属性id查询属性分组id
                Long groupId = attrAttrgroupRelationMapper.getGroupIdByAttrId(attrVo.getAttrId());
                //查询分组名称
                String groupName = attrGroupMapper.getGroupNameById(groupId);
                //设置分组名称
                attrVo.setGroupName(groupName);
            }
            if (attrVo.getCatelogId() != null) {
                //根据分类id获取分类名称
                String catelogName = categoryMapper.getCatelogNameById(attrVo.getCatelogId());
                //设置分类名称
                attrVo.setCatelogName(catelogName);
            }
            return attrVo;
        })).collect(Collectors.toList());

        //设置总条数
        page.setTotal(collect.size());
        return page.setRecords(collect);
    }

    @Override
    public IPage<AttrVO> selectSaleAttrPage(IPage<AttrVO> page, AttrVO attrVO) {
        List<Attr> list = baseMapper.selectSaleAttrPage(page, attrVO);

        List<AttrVO> collect = list.stream().map((entity -> {
            AttrVO attrVo = new AttrVO();
            BeanUtils.copyProperties(entity, attrVo);

            if (attrVo.getAttrId() != null) {
                //根据属性id查询属性分组id
                Long groupId = attrAttrgroupRelationMapper.getGroupIdByAttrId(attrVo.getAttrId());
                //查询分组名称
                String groupName = attrGroupMapper.getGroupNameById(groupId);
                //设置分组名称
                attrVo.setGroupName(groupName);
            }
            if (attrVo.getCatelogId() != null) {
                //根据分类id获取分类名称
                String catelogName = categoryMapper.getCatelogNameById(attrVo.getCatelogId());
                //设置分类名称
                attrVo.setCatelogName(catelogName);
            }
            return attrVo;
        })).collect(Collectors.toList());

        //设置总条数
        page.setTotal(collect.size());
        return page.setRecords(collect);
    }

    @Override
    public AttrVO getDetail(Long attrId) {
        //获取基本信息
        Attr attr = getById(attrId);
        //构造VO
        AttrVO attrVO = new AttrVO();
        BeanUtils.copyProperties(attr, attrVO);

        //设置分组信息
        AttrAttrgroupRelation relation = attrAttrgroupRelationMapper.selectOne(new QueryWrapper<AttrAttrgroupRelation>().eq("attr_id", attrId));
        if (relation != null) {
            attrVO.setAttrGroupId(relation.getAttrGroupId());
            //设置分组名称
            String groupName = attrGroupMapper.getGroupNameById(relation.getAttrGroupId());
            if (StringUtils.isNoneBlank(groupName)) {
                attrVO.setGroupName(groupName);
            }
        }

        //设置分类信息
        Long catelogId = getById(attrId).getCatelogId();
        Long[] paths = categoryService.searchCatelogPath(catelogId);
        if (paths != null) {
            //设置整个分类的完整路径
            attrVO.setCatelogPath(paths);
        }
        Category category = categoryService.getById(catelogId);
        if (category != null) {
            attrVO.setCatelogName(category.getName());
        }
        return attrVO;
    }

    @Transactional
    @Override
    public boolean updateAttr(AttrVO attrVO) {
        //更新基本信息
        Attr attr = new Attr();
        BeanUtils.copyProperties(attrVO, attr);
        updateById(attr);

        AttrAttrgroupRelation attrAttrgroupRelation = new AttrAttrgroupRelation();
        attrAttrgroupRelation.setAttrGroupId(attrVO.getAttrGroupId());
        attrAttrgroupRelation.setAttrId(attrVO.getAttrId());

        Integer count = attrAttrgroupRelationMapper.selectCount(new QueryWrapper<AttrAttrgroupRelation>().eq("attr_id", attrVO.getAttrId()));
        if (count > 0) {
            //修改分组关联关系
            attrAttrgroupRelationMapper.update(attrAttrgroupRelation, new UpdateWrapper<AttrAttrgroupRelation>().eq("attr_id", attrVO.getAttrId()));
        } else {
            attrAttrgroupRelationMapper.insert(attrAttrgroupRelation);
        }
        return true;
    }

    @Override
    public List<Attr> getRelationAttr(Long attrGroupId) {
        //获取所有的属性id
        List<Long> ids = attrAttrgroupRelationMapper.getAttrIdsByGroupId(attrGroupId);
        if(ids.size() >0){
            //批量获取属性集合 根据属性id(批量查询)
           return  baseMapper.selectBatchIds(ids);
        }
        return null;
    }
}
