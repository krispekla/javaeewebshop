/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kris
 */
public class CategoryRepository extends BaseRepository {

    public CategoryRepository() {
        super();
    }

    public List<Category> getAll() {
        EntityManager em = null;

        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> rootEntry = cq.from(Category.class);
            CriteriaQuery<Category> all = cq.select(rootEntry);
            TypedQuery<Category> allQuery = em.createQuery(all);
            return allQuery.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Category get(String category) {
        EntityManager em = null;

        try {
            em = getEntityManager();
           Query q =  em.createQuery("SELECT c FROM Category c WHERE c.name = :category");
           q.setParameter("category", category);
           return (Category)q.getSingleResult();   
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
