/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.models.UserRole;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kris
 */
public class UserRepository extends BaseRepository {

    public UserRepository() {
        super();
    }

    public User login(String username, String password) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p WHERE p.username = :username AND p.password = :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            return (User) q.getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean checkIfUsernameIsAvailable(String username) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p WHERE p.username = :username");
            q.setParameter("username", username);
            return q.getResultList().size() < 1;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean checkIfEmailIsAvailable(String email) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p WHERE p.email = :email");
            q.setParameter("email", email);
            return q.getResultList().size() < 1;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User register(User user) {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserRole userRole = new UserRole();
            userRole.setName("customer");
            userRole.setUsername(user.getUsername());
            em.persist(user);
            em.persist(userRole);
            em.getTransaction().commit();
            return user;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> getAll() {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p");
            return (List<User>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User getByUsername(String username) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p WHERE p.username = :username");
            q.setParameter("username", username);
            return (User) q.getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
