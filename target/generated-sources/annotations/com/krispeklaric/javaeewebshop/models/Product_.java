package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.models.Order_Item;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-08T07:52:40")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, LocalDateTime> date;
    public static volatile SingularAttribute<Product, Long> id_product;
    public static volatile ListAttribute<Product, Order_Item> order_item;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, String> manufacturer;

}