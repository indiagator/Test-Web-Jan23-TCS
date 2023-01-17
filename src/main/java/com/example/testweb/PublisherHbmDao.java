package com.example.testweb;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

@Repository
public class PublisherHbmDao // Repository
{
    //SessionFactory factory;
    @Autowired
    WebApplicationContext ctx;

    public void savePublisherTest() // testMethod
    {
        EntityManagerFactory entityManagerFactory =    ctx.getBean(EntityManagerFactory.class);

       // StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Picks up the hibernate.cfg.xml
        //factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        try(EntityManager entityManager =  entityManagerFactory.createEntityManager() )
        {
            EntityTransaction tx = entityManager.getTransaction(); // replacement for Transaction
            tx.begin();
            Publisher publisher = new Publisher();
            publisher.setName("edureka house");
            publisher.setId("001"); // Transient till this statement
            entityManager.persist(publisher); // replacement for Session | at this point the object becomes persistent
            tx.commit();
        }
    }

    public Publisher getPublisherTest(String name)
    {
        EntityManagerFactory entityManagerFactory =    ctx.getBean(EntityManagerFactory.class);
       // Publisher publisher;

        try(EntityManager entityManager =  entityManagerFactory.createEntityManager())
        {

             TypedQuery<Publisher> query =  entityManager.createQuery("from Publisher p where p.name=:name", Publisher.class);
             query.setParameter("name",name);
             return   query.getSingleResult(); // Will live in the Hibernate Cache for some time
        }


    }

    public Publisher updatePublisherTest(String name, String newName )
    {
        EntityManagerFactory entityManagerFactory =    ctx.getBean(EntityManagerFactory.class);
        Publisher publisher;

        try(EntityManager entityManager =  entityManagerFactory.createEntityManager())
        {
            entityManager.getTransaction().begin();
            TypedQuery<Publisher> query =  entityManager.createQuery("from Publisher p where p.name=:name", Publisher.class);
            query.setParameter("name",name);
            publisher =   query.getSingleResult();
            publisher.setName(newName); // database will also be updated! BE CAREFUL!
            entityManager.getTransaction().commit();

        }
        return publisher;

    }

    public void deletePublisher(String name)
    {
        EntityManagerFactory entityManagerFactory =    ctx.getBean(EntityManagerFactory.class);

        try(EntityManager entityManager =  entityManagerFactory.createEntityManager())
        {
            entityManager.getTransaction().begin();

            TypedQuery<Publisher> query =  entityManager.createQuery("from Publisher p where p.name=:name", Publisher.class);

            if(true)
            {
                query.setParameter("name",name);
                entityManager.remove(query.getSingleResult());
                entityManager.getTransaction().commit();
            }
            else { entityManager.getTransaction().rollback();}

        }

    }
}
