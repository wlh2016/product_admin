package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.util.List;

/**
 * @author Tony_Wu
 * @String 2017-4-24
 */
public class Order extends DataEntity<Order> {

    private String placeOrderDate;
    private String deliveryGoodsDate;
    private int totalPrice;       // 总价
    private int nonDeposit;        // 未结款
    private int alreadySettle;     // 已结款
    private boolean finishedStatus;
    private boolean delStatus;

    @JsonIgnore
    private Customer customer;
    @JsonIgnore
    private List<Brush> brushs;

    public String getPlaceOrderDate() {
        return placeOrderDate;
    }

    public void setPlaceOrderDate(String placeOrderDate) {
        this.placeOrderDate = placeOrderDate;
    }

    public String getDeliveryGoodsDate() {
        return deliveryGoodsDate;
    }

    public void setDeliveryGoodsDate(String deliveryGoodsDate) {
        this.deliveryGoodsDate = deliveryGoodsDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNonDeposit() {
        return nonDeposit;
    }

    public void setNonDeposit(int nonDeposit) {
        this.nonDeposit = nonDeposit;
    }

    public int getAlreadySettle() {
        return alreadySettle;
    }

    public void setAlreadySettle(int alreadySettle) {
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
