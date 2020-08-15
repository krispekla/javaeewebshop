package com.krispeklaric.javaeewebshop.models;

import com.krispeklaric.javaeewebshop.models.Order;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-15T14:14:36")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, LocalDateTime> created;
    public static volatile SingularAttribute<User, LocalDateTime> modified;
    public static volatile SingularAttribute<User, Long> id_user;
    public static volatile SingularAttribute<User, String> username;
    public static volatile ListAttribute<User, Order> order;

}