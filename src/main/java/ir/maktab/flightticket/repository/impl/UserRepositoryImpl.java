package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Boolean existByUsername(String username) {
        return entityManager.createQuery("select count(username) from User where username = :username"
                , Long.class).setParameter("username", username).getSingleResult() == 1L;
    }

    @Override
    public User findUserByUsername(String username) {
        return entityManager.createQuery(
                "from User u where u.username = :username", User.class
        ).setParameter("username", username).getSingleResult();
    }

    @Override
    public Boolean existUserByUsernameAndPassword(String username, String password) {
        return entityManager.createQuery(
                "select count(id) from User u where " +
                        "u.username = :username and u.password = :password", Long.class
        ).setParameter("username", username).setParameter("password", password)
                .getSingleResult() == 1L;
    }
}
