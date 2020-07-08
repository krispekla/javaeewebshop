package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.Product;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-08T07:52:40")
@StaticMetamodel(Order_Item.class)
public class Order_Item_ { 

    public static volatile SingularAttribute<Order_Item, Product> product;
    public static volatile SingularAttribute<Order_Item, Long> quantity;
    public static volatile SingularAttribute<Order_Item, BigDecimal> price;
    public static volatile SingularAttribute<Order_Item, Long> id_orderItem;
    public static volatile SingularAttribute<Order_Item, Order> order;

}