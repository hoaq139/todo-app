package com.example.demo5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodosRepositoryJPA extends JpaRepository<Todo,Integer> {
    @Query("select 'dinh' from Todo t where t.title=?1 or t.detail=?2")
    List<Todo> findAllByTitleOrDetail(String title, String detail);

}
