package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly = true)
    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public User show(Long id) {
        return userDAO.show(id);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void update(Long id, User updUser) {
        userDAO.update(id, updUser);
    }
}
