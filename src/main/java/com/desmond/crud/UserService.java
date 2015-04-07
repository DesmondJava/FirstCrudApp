package com.desmond.crud;

import com.desmond.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Vadym on 10.11.2014.
 */
public class UserService {

    public EntityManager em = Persistence.createEntityManagerFactory("DESMONDCOM").createEntityManager();



    public User add(User user) {
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();

        return userFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }


    public User get(long id) {
        return em.find(User.class, id);
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }



}