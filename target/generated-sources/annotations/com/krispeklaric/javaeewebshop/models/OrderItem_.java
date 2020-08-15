package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.Product;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-15T14:14:36")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Product> product;
    public static volatile SingularAttribute<OrderItem, Long> quantity;
    public static volatile SingularAttribute<OrderItem, BigDecimal> price;
    public static volatile SingularAttribute<OrderItem, Long> id_order_item;
    public static volatile SingularAttribute<OrderItem, Order> order;

}