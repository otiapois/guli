package com.fouo.coupon.service.impl;

import com.fouo.common.to.MemberPrice;
import com.fouo.common.to.SkuReductionTO;
import com.fouo.coupon.entity.SkuFullReduction;
import com.fouo.coupon.entity.SkuLadder;
import com.fouo.coupon.service.IMemberPriceService;
import com.fouo.coupon.service.ISkuLadderService;
import com.fouo.coupon.vo.SkuFullReductionVO;
import com.fouo.coupon.mapper.SkuFullReductionMapper;
import com.fouo.coupon.service.ISkuFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品满减信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReduction> implements ISkuFullReductionService {

	@Autowired
	private ISkuLadderService iSkuLadderService;
	@Autowired
	private IMemberPriceService iMemberPriceService;

	@Override
	public IPage<SkuFullReductionVO> selectSkuFullReductionPage(IPage<SkuFullReductionVO> page, SkuFullReductionVO skuFullReduction) {
		return page.setRecords(baseMapper.selectSkuFullReductionPage(page, skuFullReduction));
	}

	@Override
	public boolean saveSkuReduction(SkuReductionTO skuReductionTO) {
		//1.保存满减打折 会员价
		SkuLadder skuLadder = new SkuLadder();
		skuLadder.setSkuId(skuReductionTO.getSkuId());
		//满几件
		skuLadder.setFullCount(skuReductionTO.getFullCount());
		//打几折
		skuLadder.setDiscount(skuReductionTO.getDiscount());
		skuLadder.setAddOther(skuReductionTO.getCountStatus());
		if(skuReductionTO.getFullCount()>0){
			iSkuLadderService.save(skuLadder);
		}
	//==================================================================
		SkuFullReduction skuFullReduction = new SkuFullReduction();
		BeanUtils.copyProperties(skuReductionTO, skuFullReduction);
		if(skuReductionTO.getFullPrice().compareTo(new BigDecimal(0))==1){
			iSkuLadderService.save(skuLadder);
		}
		this.save(skuFullReduction);
	//==================================================================
		List<MemberPrice> memberPrice = skuReductionTO.getMemberPrice();
		List<com.fouo.coupon.entity.MemberPrice> collect = memberPrice.stream().map(item -> {
			com.fouo.coupon.entity.MemberPrice price = new com.fouo.coupon.entity.MemberPrice();
			price.setSkuId(skuReductionTO.getSkuId());
			price.setMemberLevelId(item.getMemberLevelId());
			price.setMemberLevelName(item.getMemberLevelName());
			price.setMemberPrice(item.getMemberPrice());
			price.setAddOther(item.getAddOther());
			return price;
		}).filter(item->{
			return item.getMemberPrice().compareTo(new BigDecimal(0)) ==1 ;
		}).collect(Collectors.toList());
		iMemberPriceService.saveBatch(collect);

		return false;
	}

}
