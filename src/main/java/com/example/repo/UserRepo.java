package com.example.repo;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select * from user where user.email = :email", nativeQuery = true)
    public User findByEmail(@Param("email") String email);
}
