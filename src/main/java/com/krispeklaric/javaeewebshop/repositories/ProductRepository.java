/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.models.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pekla
 */
public class ProductRepository extends BaseRepository {

    public ProductRepository() {
        super();
    }

    public List<Product> getAll(Category category) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Product p WHERE p.category = :categoryid");
            q.setParameter("categoryid", category);
            return (List<Product>) q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Product get(long id) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT p FROM Product p WHERE p.id_product = :id_product");
            q.setParameter("id_product", id);
            return (Product) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
