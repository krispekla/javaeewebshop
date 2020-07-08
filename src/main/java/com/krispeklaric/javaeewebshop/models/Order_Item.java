/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Kris
 */
@Entity
public class Order_Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_orderItem;

    private long quantity;

    @Column(columnDefinition = "Money")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof Order_Item)) {
            return false;
        }
        Order_Item other = (Order_Item) object;
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
