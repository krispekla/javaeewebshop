/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.dtos;

import com.krispeklaric.javaeewebshop.models.Address;
import com.krispeklaric.javaeewebshop.models.PaymentType;
import com.krispeklaric.javaeewebshop.models.User;

/**
 *
 * @author Kris
 */
public class OrderDTO extends CartDTO {

    private Address address;
    private PaymentType paymentType;
    private User user;

    public OrderDTO() {
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }



}
