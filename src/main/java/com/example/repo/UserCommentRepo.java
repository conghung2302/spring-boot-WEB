package com.example.repo;

import com.example.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepo extends JpaRepository<UserComment, Long> {
}
