package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
        return users;
    }

    @Override
    public void save(User user) {
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User show(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void update(Long id, User updUser) {
        entityManager.merge(updUser);

    }

    @Override
    public User getUserByName(String name) {
        List<User> userList = index();
        for(User user: userList) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
