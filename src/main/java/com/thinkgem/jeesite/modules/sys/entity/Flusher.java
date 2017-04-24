package com.thinkgem.jeesite.modules.sys.entity;

import java.math.BigDecimal;

/**
 * @author Tony_Wu
 * @date 2017-4-24
 */
public class Flusher {

    private long id;
    private float size;                 // 尺寸
    private BigDecimal unit_price;      // 每寸单价
    private int countOfPerPackage;      // 每个包装数量
    private long packageCount;          // 包装数量
    private float freight;              // 运费

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

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
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

    @Override
    public String toString() {
        return "Flusher{" +
                "id=" + id +
                ", size=" + size +
                ", unit_price=" + unit_price +
                ", countOfPerPackage=" + countOfPerPackage +
                ", packageCount=" + packageCount +
                ", freight=" + freight +
                '}';
    }
}
