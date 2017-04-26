package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * @author Tony_Wu
 * @date 2017-4-24
 */
public class Brush extends DataEntity<Brush> {

    private Float size;                     // 尺寸
    private Float unitPrice;                // 每寸单价
    private Integer countOfPerPackage;      // 每个包装数量
    private Integer packageCount;           // 包装数量
    private Integer freight;                // 运费
    private Float totalPrice;               // 总价
    private boolean delStatus;

    @JsonIgnore
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCountOfPerPackage() {
        return countOfPerPackage;
    }

    public void setCountOfPerPackage(Integer countOfPerPackage) {
        this.countOfPerPackage = countOfPerPackage;
    }

    public long getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(Integer packageCount) {
        this.packageCount = packageCount;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        return "Brush{" +
                "size=" + size +
                ", unitPrice=" + unitPrice +
                ", countOfPerPackage=" + countOfPerPackage +
                ", packageCount=" + packageCount +
                ", freight=" + freight +
                ", totalPrice=" + totalPrice +
                ", delStatus=" + delStatus +
                '}';
    }
}
