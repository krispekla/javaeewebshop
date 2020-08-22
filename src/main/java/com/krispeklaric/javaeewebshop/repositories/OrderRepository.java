/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.Address;
import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.OrderItem;
import com.krispeklaric.javaeewebshop.models.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kris
 */
public class OrderRepository extends BaseRepository {

    public OrderRepository() {
        super();
    }

    public Order create(Order order) {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.clear();

            em.getTransaction().begin();
            Address address = order.getAddress();
            em.persist(address);
            em.persist(order);
            for (OrderItem item : order.getOrderItem()) {
                item.setOrder(order);
                em.persist(item);
            }
            em.getTransaction().commit();
            return order;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> getAll(User user) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Order p WHERE P.user = :userid");
            q.setParameter("userid", user);
            return (List<Order>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> getAll() {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Order p");
            return (List<Order>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> getAll(LocalDate created) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Order p WHERE p.created  BETWEEN :start AND :end");
            q.setParameter("start", created.atStartOfDay());
            q.setParameter("end", created.plusDays(1).atStartOfDay());
            return (List<Order>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> getAll(User user, LocalDate date) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Order p WHERE P.user = :userid AND p.created  BETWEEN :start AND :end");
            q.setParameter("userid", user);
            q.setParameter("start", date.atStartOfDay());
            q.setParameter("end", date.plusDays(1).atStartOfDay());
            return (List<Order>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
