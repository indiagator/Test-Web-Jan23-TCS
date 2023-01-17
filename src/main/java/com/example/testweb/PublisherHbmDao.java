package com.example.testweb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PublisherHbmDao
{

    public void savePublisher()
    {

        SessionFactory factory;

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        try(Session session = factory.openSession() )
        {
            Transaction tx = session.beginTransaction();
            Publisher publisher = new Publisher();
            publisher.setName("edureka house");
            publisher.setId("001");
            session.save(publisher);
            tx.commit();
        }
    }

}
