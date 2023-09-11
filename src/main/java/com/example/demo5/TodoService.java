package com.example.demo5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodosRepositoryJPA todosRepositoryJPA;
    public List<Todo> getAll() {

        return todosRepositoryJPA.findAll();
        //return todosRepositoryJPA.findAllByTitleOrDetail("hoang","dinh");

    }


    public void save(Todo todo) {
        todosRepositoryJPA.save(todo);
    }

    public void delete(int id) {
        todosRepositoryJPA.deleteById(id);
    }

    public Todo findById(int id) {
        return todosRepositoryJPA.findById(id).get();
    }
}
