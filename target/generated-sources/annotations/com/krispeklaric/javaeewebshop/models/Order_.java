package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Order_Item;
import com.krispeklaric.javaeewebshop.models.PaymentType;
import com.krispeklaric.javaeewebshop.models.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-08T07:52:40")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Long> id_order;
    public static volatile SingularAttribute<Order, BigDecimal> total;
    public static volatile ListAttribute<Order, Order_Item> order_item;
    public static volatile SingularAttribute<Order, LocalDateTime> created;
    public static volatile SingularAttribute<Order, User> user;
    public static volatile SingularAttribute<Order, PaymentType> paymentType;

}