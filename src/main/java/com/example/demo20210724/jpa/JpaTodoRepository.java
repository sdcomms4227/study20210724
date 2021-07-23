package com.example.demo20210724.jpa;

import com.example.demo20210724.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTodoRepository extends JpaRepository<TodoEntity,Integer> {
    List<TodoEntity> findAllByDeleteYn(String deleteYn);
    TodoEntity findByIdxAndDeleteYn(Integer idx, String deleteYn);
}
