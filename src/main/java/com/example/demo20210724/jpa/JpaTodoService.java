package com.example.demo20210724.jpa;

import com.example.demo20210724.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaTodoService {

    private final JpaTodoRepository jpaTodoRepository;

    public List<TodoEntity> findAll() {
        return jpaTodoRepository.findAllByDeleteYn("N");
    }

    @Transactional
    public void insert(List<String> stringList){
        stringList.forEach(content -> {
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(content)
                    .doneYn("N")
                    .deleteYn("N")
                    .createDate(LocalDateTime.now())
                    .build();
            jpaTodoRepository.save(todoEntity);
        });
    }

    @Transactional
    public void changeDone(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = jpaTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn())? "N" : "Y");
            todoEntity.setUpdateDate(LocalDateTime.now());
        });
    }

    @Transactional
    public void delete(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = jpaTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDeleteYn("Y");
            todoEntity.setDeleteDate(LocalDateTime.now());
        });
    }

}
