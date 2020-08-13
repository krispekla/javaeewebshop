/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.repositories;

import com.krispeklaric.javaeewebshop.utils.FactoryListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Kris
 */
public class BaseRepository {

    public EntityManagerFactory emf;

    public BaseRepository() {
        if (emf == null) {
            emf = FactoryListener.getOrCreateEntityManagerFactory();
        }
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
}
