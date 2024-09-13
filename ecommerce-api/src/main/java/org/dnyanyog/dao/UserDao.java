package org.dnyanyog.dao;


import java.util.Optional;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<Users, Integer> {
    public Users findByLoginName(String loginName);
    
 //   public Optional<Users> findByUseridAndFirstname(Integer user_id, String firstname);
    
   
}
