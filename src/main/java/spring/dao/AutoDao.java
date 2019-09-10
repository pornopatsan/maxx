package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.AutoEntity;

import java.util.List;

public class AutoDao {

    @Autowired
    SessionFactory factory;

    public AutoEntity getById(int id){
        Session session = factory.openSession();
        AutoEntity entity = session.get(AutoEntity.class, id);
        session.close();
        return entity;
    }

    public void save(AutoEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void delete(AutoEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public void update(AutoEntity entity) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public List<AutoEntity> findAll(){
        Session session = factory.openSession();
        List<AutoEntity> list = (List<AutoEntity>) session.createQuery("from AutoEntity").list();
        session.close();
        return list;
    }

}
