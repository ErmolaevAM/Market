package ssu.edu.java.market.ermolaxe.dao;

import ssu.edu.java.market.ermolaxe.model.Good;
import ssu.edu.java.market.ermolaxe.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Александр on 11.05.2017.
 */
public class MarketplaceDaoImpl implements MarketplaceDAO {

    private EntityManager entityManager;
    private static MarketplaceDaoImpl instance;

    private MarketplaceDaoImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("marketplace").createEntityManager();
    }

    public static MarketplaceDaoImpl getInstance(){
        if (instance != null){
            return instance;
        } else {
            instance = new MarketplaceDaoImpl();
            return instance;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("select a from User a", User.class).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    @Override
    public User getUserByName(String username) {
        User user;
        entityManager.getTransaction().begin();
        user = entityManager.createQuery("select a from User a where name = ?", User.class).setParameter(0, username).getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user;
        entityManager.getTransaction().begin();
        user = entityManager.createQuery("select a from User a where id = ?", User.class).setParameter(0, id).getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> goods;
        entityManager.getTransaction().begin();
        goods = entityManager.createQuery("select a from Good a", Good.class).getResultList();
        entityManager.getTransaction().commit();
        return goods;
    }

    @Override
    public Good getGoodByName(String goodname) {
        Good good;
        entityManager.getTransaction().begin();
        good = entityManager.createQuery("select a from Good a where name = ?", Good.class).setParameter(0, goodname).getSingleResult();
        entityManager.getTransaction().commit();
        return good;
    }

    @Override
    public Good getGoodById(int id) {
        Good good;
        entityManager.getTransaction().begin();
        good = entityManager.createQuery("select a from Good a where id = ?", Good.class).setParameter(0, id).getSingleResult();
        entityManager.getTransaction().commit();
        return good;
    }
}
