package com.app.repository;

import com.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryInterface extends JpaRepository <Task, Long> {


}
