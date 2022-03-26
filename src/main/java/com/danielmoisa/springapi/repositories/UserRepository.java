package com.danielmoisa.springapi.repositories;

import com.danielmoisa.springapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);
}
