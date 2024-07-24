package org.dnyanyog.dao;


import org.dnyanyog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {
    public User findByLoginName(String loginName);
   
}
