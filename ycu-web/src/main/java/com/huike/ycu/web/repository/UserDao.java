package com.huike.ycu.web.repository;


import com.huike.ycu.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findById(long id);

    void deleteById(Long id);

}
