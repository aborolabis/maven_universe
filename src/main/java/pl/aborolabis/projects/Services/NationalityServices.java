package pl.aborolabis.projects.Services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.aborolabis.projects.EntityObjects.Hero;
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

    public int createANationalityWithNameOnly(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Nationality nationality = new Nationality (name);
        int id = (int) session.save(nationality);

        transaction.commit();
        session.close();

        return id;
    }

    public int createANationality(String name, Hero owner, List<Hero> listOfCitizens){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Nationality nationality = new Nationality (name, owner, listOfCitizens);
        int id = (int) session.save(nationality);

        transaction.commit();
        session.close();

        return id;
    }

    public int save(Nationality nation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int id = (int) session.save(nation);

        transaction.commit();
        session.close();

        return id;
    }

    public void update(Nationality nationality) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(nationality);

        transaction.commit();
        session.close();
    }

    public void saveOrUpdate(Nationality nation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(nation);

        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Nationality nationality = (Nationality) session.get(Nationality.class, id);
        session.delete(nationality);

        transaction.commit();
        session.close();
    }

    public Nationality findNationByHisId(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Nationality nation = (Nationality) session.get(Nationality.class, id);

        transaction.commit();
        session.close();

        return nation;
    }

    public Nationality findNationByHisName(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT n FROM Nationality n WHERE n.name=:name");
        query.setParameter("name", name);
        List<Nationality> nations = query.list();

        transaction.commit();
        session.close();

        return nations.isEmpty() ? null : nations.get(0);
    }

}
