/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services.interfaces;

import com.krispeklaric.javaeewebshop.dtos.OrderDTO;
import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.User;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Kris
 */
public interface IOrderService {

    Order create(OrderDTO order);

    List<Order> getAll(User user);

    List<Order> getAll();

    List<Order> getAll(LocalDateTime date);

}
