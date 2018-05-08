package pl.aborolabis.projects.Services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.aborolabis.projects.EntityObjects.Hero;
import pl.aborolabis.projects.EntityObjects.Nationality;
import pl.aborolabis.projects.Utils.HibernateUtils;

import java.util.List;

public class HeroServices {

    private SessionFactory sessionFactory;

    public HeroServices() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    public List<Hero> findAllHeroes(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT h FROM Hero h ORDER BY h.age ASC");
        List<Hero> listOfHeroes = query.list();

        transaction.commit();
        session.close();

        return listOfHeroes;
    }

    public int createAHero(String nickname, String firstName, String lastName, double height, int weight, int age, Nationality nationality){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = new Hero (nickname, firstName, lastName, height, weight, age, nationality);
        int id = (int) session.save(hero);

        transaction.commit();
        session.close();

        return id;
    }

    public int save(Hero hero) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int id = (int) session.save(hero);

        transaction.commit();
        session.close();

        return id;
    }

    public void update(Hero hero) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(hero);

        transaction.commit();
        session.close();
    }

    public void saveOrUpdate(Hero hero) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(hero);

        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = (Hero) session.get(Hero.class, id);
        session.delete(hero);

        transaction.commit();
        session.close();
    }

    public Hero findHeroByHisId(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = (Hero) session.get(Hero.class, id);

        transaction.commit();
        session.close();

        return hero;
    }

    public Hero findHeroByHisNickname(String nickname){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT h FROM Hero h WHERE h.nickname=:nickname");
        query.setParameter("nickname", nickname);
        List<Hero> heroes = query.list();

        transaction.commit();
        session.close();

        return heroes.isEmpty() ? null : heroes.get(0);
    }


}
