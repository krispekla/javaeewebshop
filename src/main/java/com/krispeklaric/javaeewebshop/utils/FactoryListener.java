/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Kris
 */
public class FactoryListener implements ServletContextListener {

    static EntityManagerFactory entityManagerFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        entityManagerFactory = Persistence.createEntityManagerFactory("com.krispeklaric_javaeewebshop_war_1.0PU");
        context.setAttribute("emf", entityManagerFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        entityManagerFactory.close();
    }

    public static EntityManagerFactory getOrCreateEntityManagerFactory() {

        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("com.krispeklaric_javaeewebshop_war_1.0PU");
            return entityManagerFactory;
        }

        return entityManagerFactory;
    }
}
