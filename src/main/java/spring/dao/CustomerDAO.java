package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.CustomerEntity;

import java.util.List;

public class CustomerDAO {

    @Autowired
    SessionFactory factory;

    public CustomerEntity getById(int id){
        Session session = factory.openSession();
        CustomerEntity entity = session.get(CustomerEntity.class, id);
        session.close();
        return entity;
    }

    public void save(CustomerEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void delete(CustomerEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public void update(CustomerEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public List<CustomerEntity> findAll(){
        Session session = factory.openSession();
        List<CustomerEntity> list = (List<CustomerEntity>) session.createQuery("from CustomerEntity").list();
        session.close();
        return list;
    }

}
