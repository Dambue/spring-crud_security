package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    void save(User user);
    void delete(Long id);
    User show(Long id);
    void update(Long id, User updUser);
}

