package pl.aborolabis.projects.Services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.aborolabis.projects.EntityObjects.Nationality;
import pl.aborolabis.projects.Utils.HibernateUtils;

import java.util.List;

public class NationalityServices {

    private SessionFactory sessionFactory;

    public NationalityServices() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    public List<Nationality> findAllNations(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT n FROM Nationality n ORDER BY n.name ASC");
        List<Nationality> listOfNations = query.list();

        transaction.commit();
        session.close();

        return listOfNations;
    }

}
