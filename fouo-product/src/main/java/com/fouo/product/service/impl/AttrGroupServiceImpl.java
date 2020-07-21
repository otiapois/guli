package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.common.utils.StringUtil;
import com.fouo.product.entity.Attr;
import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.entity.AttrGroup;
import com.fouo.product.enums.AttrEnum;
import com.fouo.product.mapper.AttrAttrgroupRelationMapper;
import com.fouo.product.mapper.AttrMapper;
import com.fouo.product.service.IAttrService;
import com.fouo.product.vo.AttrGroupVO;
import com.fouo.product.mapper.AttrGroupMapper;
import com.fouo.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性分组 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {

    @Autowired
    private AttrMapper attrMapper;
    @Autowired
    private IAttrService attrService;
    @Autowired
    private AttrAttrgroupRelationMapper relationMapper;

    @Override
    public IPage<AttrGroupVO> selectAttrGroupPage(IPage<AttrGroupVO> page, AttrGroupVO attrGroup) {
        return page.setRecords(baseMapper.selectAttrGroupPage(page, attrGroup));
    }

    /**
     * 找出改分类下所有的属性
     * 排除该分类下所有组所关联的属性
     * 将剩下的属性封装到Page中返回
     *
     * @param page
     * @param attrGroupVO
     * @return
     */
    @Override
    public IPage<Attr> selectNotRelation(IPage<Attr> page, AttrGroupVO attrGroupVO) {
        //当前分组只能关联 自己所属的分类里面 的所有属性
        AttrGroup attrGroup = baseMapper.selectById(attrGroupVO.getAttrGroupId());
        Long catelogId = attrGroup.getCatelogId();
        //当前分组只能关联 别的分组没有引用的属性
        //找到当前分类下的其他分组（找出所有分组后再排除当前分组）
        List<AttrGroup> groups = baseMapper.selectList(new QueryWrapper<AttrGroup>().eq("catelog_id", catelogId));
        // 找到这些分组关联的属性
        List<Long> groupIds = groups.stream().map(item -> {
            return item.getAttrGroupId();
        }).collect(Collectors.toList());
        //非空判断
        if (groupIds != null && groupIds.size() > 0) {
            List<AttrAttrgroupRelation> relations = relationMapper.selectList(new QueryWrapper<AttrAttrgroupRelation>().in("attr_group_id", groupIds));
            //拿到所关联的所有属性的id
            List<Long> attrIds = relations.stream().map(relation -> {
                Long attrId = relation.getAttrId();
                return attrId;
            }).collect(Collectors.toList());
            //从当前分类的所有属性中移除这些属性
            QueryWrapper<Attr> wrapper = new QueryWrapper<Attr>().eq("catelog_id", catelogId).eq("attr_type", AttrEnum.ATTR_TYPE_BASE.getCode());
            if (attrIds != null && attrIds.size() > 0) {
                wrapper.notIn("attr_id", attrIds);
            }
            //添加条件
            if (StringUtils.isNoneBlank(attrGroupVO.getSearchKeyword())) {
                wrapper.and((w) -> {
                    w.eq("attr_id", attrGroupVO.getSearchKeyword()).or().like("attr_name", attrGroupVO.getSearchKeyword());
                });
            }
            IPage<Attr> attrPage = attrMapper.selectPage(page, wrapper);
            attrPage.setTotal(attrPage.getRecords().size());
            return attrPage;
        } else {
            return attrMapper.selectPage(page, null);
        }
    }

    @Override
    public List<AttrGroupVO> getAttrGroupWithAttrs(Long catalogId) {
        //查询当前分类下所有属性分组
        List<AttrGroup> groups = baseMapper.selectList(new QueryWrapper<AttrGroup>().eq("catelog_id", catalogId));
        //查询每个分组的所有属性
        List<AttrGroupVO> attrGroupVOS = groups.stream().map(group -> {
            AttrGroupVO groupVO = new AttrGroupVO();
            BeanUtils.copyProperties(group, groupVO);
            //根据分组id获取该分组的所有属性
            groupVO.setAttrs(attrService.getRelationAttr(group.getAttrGroupId()));
            return groupVO;
        }).collect(Collectors.toList());
        return attrGroupVOS;
    }
}
