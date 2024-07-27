package org.dnyanyog.dao;


import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<Users, Integer> {
    public Users findByLoginName(String loginName);
   
}
