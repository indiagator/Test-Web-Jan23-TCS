package com.example.testweb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class TestwebApplicationTests {



    @Test
    void contextLoads() {
    }

    @BeforeTestClass
    public void setup()
    {

    }

    @Test
    public void testSavePublisher()
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
