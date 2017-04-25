package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Tony_Wu
 * @date 2017-4-24
 */
public class Brush {

    private long id;
    private float size;                 // 尺寸
    private float unit_price;           // 每寸单价
    private int countOfPerPackage;      // 每个包装数量
    private long packageCount;          // 包装数量
    private float freight;              // 运费
    private float totalPrice;           // 总价

    @JsonIgnore
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public int getCountOfPerPackage() {
        return countOfPerPackage;
    }

    public void setCountOfPerPackage(int countOfPerPackage) {
        this.countOfPerPackage = countOfPerPackage;
    }

    public long getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(long packageCount) {
        this.packageCount = packageCount;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
