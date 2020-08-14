/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.dtos;

import com.krispeklaric.javaeewebshop.models.OrderItem;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pekla
 */
public class CartDTO implements Serializable {

    private List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getNumberOfItems() {
        int quantity = 0;
        if (items == null) {
            return quantity;
        }

        for (OrderItem item : items) {
            quantity += item.getQuantity();
        }
        return quantity;
    }
}
