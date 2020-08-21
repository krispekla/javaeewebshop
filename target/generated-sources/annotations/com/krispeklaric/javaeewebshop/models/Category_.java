package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Product;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-21T14:28:33")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile ListAttribute<Category, Product> product;
    public static volatile SingularAttribute<Category, LocalDateTime> created;
    public static volatile SingularAttribute<Category, Long> id_category;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, LocalDateTime> modified;
    public static volatile SingularAttribute<Category, String> logoUrl;

}