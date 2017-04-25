package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
public class Customer {

    private long id;
    private String name;
    private String phone;
    private String address;
    private long nonDeposit;        // 未结款
    private long alreadySettle;     // 已结款

    @JsonIgnore
    private List<Order> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", nonDeposit=" + nonDeposit +
                ", alreadySettle=" + alreadySettle +
                '}';
    }
}