package com.app.repository;

import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository <User, Long> {


}
