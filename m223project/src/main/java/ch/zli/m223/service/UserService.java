package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {
    //DELETE, POST PUT

    @Inject
    private EntityManager entityManager;

    public List<User> getUsers() {
        var qry = entityManager.createQuery("FROM User", User.class);
        return qry.getResultList();
    }

    @Transactional
    public User createUsers(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    public void deleteUser(Long id) {
        var qry = entityManager.find(User.class, id);
        entityManager.remove(qry);
    }

    @Transactional
    public User updateUser(User user, Long id) {
        return entityManager.merge(user);
    }
}
