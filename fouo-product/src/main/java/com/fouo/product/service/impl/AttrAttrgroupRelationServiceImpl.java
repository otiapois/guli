package com.fouo.product.service.impl;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.fouo.product.mapper.AttrAttrgroupRelationMapper;
import com.fouo.product.service.IAttrAttrgroupRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.AttrGroupVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性&属性分组关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation> implements IAttrAttrgroupRelationService {

    @Override
    public IPage<AttrAttrgroupRelationVO> selectAttrAttrgroupRelationPage(IPage<AttrAttrgroupRelationVO> page, AttrAttrgroupRelationVO attrAttrgroupRelation) {
        return page.setRecords(baseMapper.selectAttrAttrgroupRelationPage(page, attrAttrgroupRelation));
    }

    @Override
    public boolean removeRelation(Long attrId, Long attrGroupId) {
        return baseMapper.removeRelation(attrId, attrGroupId);
    }

    @Override
    public boolean removeRelationBatch(List<AttrGroupVO> list) {
//        boolean flag = false;
//        for (AttrGroupVO attrGroupVO:list){
//            flag = baseMapper.removeRelation(attrGroupVO.getAttrId(), attrGroupVO.getAttrGroupId());
//        }
        return baseMapper.removeRelationBatch(list);
    }

    @Override
    public boolean addRelationBatch(List<AttrAttrgroupRelationVO> list) {
        List<AttrAttrgroupRelation> collect = list.stream().map(item -> {
            AttrAttrgroupRelation relation = new AttrAttrgroupRelation();
            BeanUtils.copyProperties(item, relation);
            return relation;
        }).collect(Collectors.toList());
        return this.saveBatch(collect);
    }

}
