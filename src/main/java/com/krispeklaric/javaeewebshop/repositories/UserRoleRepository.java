/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.models.UserRole;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kris
 */
public class UserRoleRepository extends BaseRepository {

    public UserRoleRepository() {
        super();
    }

    public UserRole get(User user) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM UserRole p WHERE p.username = :username");
            q.setParameter("username", user.getUsername());
            return (UserRole) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
