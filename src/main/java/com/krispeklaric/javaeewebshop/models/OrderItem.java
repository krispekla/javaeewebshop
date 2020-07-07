/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Kris
 */
@Entity
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_orderItem;

    private long order_id;

    private long product_id;

    private int quantity;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Long getId() {
        return id_orderItem;
    }

    public void setId(Long id) {
        this.id_orderItem = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_orderItem != null ? id_orderItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id_orderItem == null && other.id_orderItem != null) || (this.id_orderItem != null && !this.id_orderItem.equals(other.id_orderItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.krispeklaric.javaeewebshop.models.OrderItem[ id=" + id_orderItem + " ]";
    }

}
