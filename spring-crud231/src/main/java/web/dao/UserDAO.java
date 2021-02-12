package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    void save(User user);
    void delete(Long id);
    User show(Long id);
    void update(Long id, User updUser);
    User getUserByName(String name);
}
