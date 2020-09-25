package com.huike.ycu.web.service;

import com.huike.ycu.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(Long id);

}
