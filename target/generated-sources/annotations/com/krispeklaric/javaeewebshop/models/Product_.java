package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.models.OrderItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-22T11:45:54")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> imgUrl;
    public static volatile SingularAttribute<Product, LocalDateTime> date;
    public static volatile SingularAttribute<Product, Long> id_product;
    public static volatile ListAttribute<Product, OrderItem> orderItem;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, String> manufacturer;

}