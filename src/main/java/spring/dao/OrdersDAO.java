package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.OrdersEntity;

import java.util.List;

public class OrdersDAO {

    @Autowired
    SessionFactory factory;

    public OrdersEntity getById(int id){
        Session session = factory.openSession();
        OrdersEntity entity = session.get(OrdersEntity.class, id);
        session.close();
        return entity;
    }

    public void save(OrdersEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void delete(OrdersEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public void update(OrdersEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public List<OrdersEntity> findAll(){
        Session session = factory.openSession();
        List<OrdersEntity> list = (List<OrdersEntity>) session.createQuery("from OrdersEntity").list();
        session.close();
        return list;
    }

    public List<OrdersEntity> findByAutoId(Integer autoId) {
        Session session = factory.openSession();
        Query query = session.createQuery("from OrdersEntity O where O.auto.id = :aid");
        query.setParameter("aid", autoId);
        List<OrdersEntity> orders = (List<OrdersEntity>) query.getResultList();
        session.close();
        return orders;
    }
}
