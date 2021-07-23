package com.example.demo20210724.querydsl;

import com.example.demo20210724.entity.TodoEntity;

import java.util.List;

public interface QueryDslTodoCustomRepository {

    List<TodoEntity> findAllByDeleteYn(String deleteYn);

    TodoEntity findByIdxAndDeleteYn(Integer idx, String deleteYn);

}
