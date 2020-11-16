package com.fouo.cart.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车对象
 * 需要重写的属性，必须重写他的get方法，保证每次获取属性都会进行计算
 *
 * @author fouo
 * @date 2020/8/31 17:27
 */
public class Cart {
    /**
     * 商品的商品项
     */
    private List<CartItem> items;

    /**
     * 商品的数量
     */
    private Integer countNum;

    /**
     * 商品类型数量
     */
    private Integer countType;

    /**
     * 商品总价
     */
    private BigDecimal totalAmount;

    /**
     * 优惠价格
     */
    private BigDecimal reduce = new BigDecimal("0");


    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Integer getCountNum() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItem item : items) {
                count += item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItem item : items) {
                count++;
            }
        }
        return count;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");

        if (items != null && items.size() > 0) {
            for (CartItem item : items) {
                BigDecimal totalPrice = item.getTotalPrice();
                amount = amount.add(totalPrice);
            }
        }
        //减去优惠价格
        BigDecimal subtract = amount.subtract(getReduce());
        return subtract;
    }


    public BigDecimal getReduce() {
        return reduce;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }
}
