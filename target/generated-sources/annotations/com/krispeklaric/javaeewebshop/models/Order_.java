package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.OrderItem;
import com.krispeklaric.javaeewebshop.models.PaymentType;
import com.krispeklaric.javaeewebshop.models.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T12:41:14")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Long> idOrder;
    public static volatile SingularAttribute<Order, BigDecimal> total;
    public static volatile ListAttribute<Order, OrderItem> orderItem;
    public static volatile SingularAttribute<Order, LocalDateTime> created;
    public static volatile SingularAttribute<Order, User> user;
    public static volatile SingularAttribute<Order, PaymentType> paymentType;

}