/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.utils;

import java.util.regex.Pattern;

/**
 *
 * @author Kris
 */
public class Constants {

    public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", Pattern.CASE_INSENSITIVE);

    public static final String CART = "cart";
    public static final String STATUS = "status";
    public static final String MESSAGE = "message";
    public static final String ROLE = "role";
    public static final String IS_AUTHENTICATED = "isAuthenticated";
    public static final String USER = "user";
    public static final String USERS = "users";
    public static final String ORDERS = "orders";
    public static final String PRODUCTS = "products";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_DATE = "date";
    public static final String PARAM_CATEGORY = "category";
    public static final String PARAM_FIRSTNAME = "firstname";
    public static final String PARAM_LASTNAME = "lastname";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_ = "email";

}
