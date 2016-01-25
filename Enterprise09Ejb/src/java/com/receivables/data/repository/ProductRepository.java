/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.receivables.data.repository;

import com.receivables.data.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class ProductRepository {
    public void persist(Product product){
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("Enterprise09EjbPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();
        manager.close();
    }
    public List<Product> list(){
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("Enterprise09EjbPU");
        EntityManager manager = factory.createEntityManager();
        String string="select product from Product as product";
        Query query=manager.createQuery(string);
        List<Product> productlist=query.getResultList();
        manager.close();
        return productlist;
    }
   public void merge(Product product){
       EntityManagerFactory factory=Persistence.createEntityManagerFactory("Enterprise09EjbPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(product);
        manager.getTransaction().commit();
        manager.close();
   }
}
