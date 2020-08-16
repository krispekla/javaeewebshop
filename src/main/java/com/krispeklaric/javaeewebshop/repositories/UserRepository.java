/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
            Query q = em.createQuery("SELECT p FROM User p WHERE p.username = :username AND p.password == :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            return (User) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean checkIfUsernameIsAvailable(String username) {
        return true;
    }

    public User register(User user) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM User p WHERE p.username = :username AND p.password == :password");
//            q.setParameter("username", user.);
//            q.setParameter("password", password);
            return (User) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
