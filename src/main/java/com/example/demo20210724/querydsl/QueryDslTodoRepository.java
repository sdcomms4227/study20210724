package com.example.demo20210724.querydsl;

import com.example.demo20210724.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryDslTodoRepository extends JpaRepository<TodoEntity,Integer>, QueryDslTodoCustomRepository {

}
