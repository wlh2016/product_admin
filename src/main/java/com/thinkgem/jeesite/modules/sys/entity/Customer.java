package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.util.List;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
public class Customer extends DataEntity<Customer> {

    private String name;
    private String phone;
    private String address;
    private int nonDeposit;        // 未结款
    private int alreadySettle;     // 已结款
    private boolean delStatus;

    @JsonIgnore
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", nonDeposit=" + nonDeposit +
                ", alreadySettle=" + alreadySettle +
                ", delStatus=" + delStatus +
                '}';
    }
}
