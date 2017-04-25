package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Tony_Wu
 * @date 2017-4-24
 */
public class Order extends DataEntity<Order> {

    private Date placeOrderDate;
    private Date deliveryGoodsDate;
    private float totalPrice;       // 总价
    private long nonDeposit;        // 未结款
    private long alreadySettle;     // 已结款
    private boolean finishedStatus;
    private boolean delStatus;

    @JsonIgnore
    private Customer customer;
    @JsonIgnore
    private List<Brush> brushs;

    public Date getPlaceOrderDate() {
        return placeOrderDate;
    }

    public void setPlaceOrderDate(Date placeOrderDate) {
        this.placeOrderDate = placeOrderDate;
    }

    public Date getDeliveryGoodsDate() {
        return deliveryGoodsDate;
    }

    public void setDeliveryGoodsDate(Date deliveryGoodsDate) {
        this.deliveryGoodsDate = deliveryGoodsDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getNonDeposit() {
        return nonDeposit;
    }

    public void setNonDeposit(long nonDeposit) {
        this.nonDeposit = nonDeposit;
    }

    public long getAlreadySettle() {
        return alreadySettle;
    }

    public void setAlreadySettle(long alreadySettle) {
        this.alreadySettle = alreadySettle;
    }

    public boolean isFinishedStatus() {
        return finishedStatus;
    }

    public void setFinishedStatus(boolean finishedStatus) {
        this.finishedStatus = finishedStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Brush> getBrushs() {
        return brushs;
    }

    public void setBrushs(List<Brush> brushs) {
        this.brushs = brushs;
    }

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "placeOrderDate=" + placeOrderDate +
                ", deliveryGoodsDate=" + deliveryGoodsDate +
                ", totalPrice=" + totalPrice +
                ", nonDeposit=" + nonDeposit +
                ", alreadySettle=" + alreadySettle +
                ", finishedStatus=" + finishedStatus +
                ", delStatus=" + delStatus +
                '}';
    }
}
