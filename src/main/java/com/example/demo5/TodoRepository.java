package com.example.demo5;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private List<Todo> todoList;
    public TodoRepository(){
        todoList = new ArrayList<>();
                todoList.add(Todo.builder()
                        .id(1)
                        .title("Monday")
                        .detail("Go to School")
                        .build());
    }

    public List<Todo> getAll() {
        return todoList;
    }

    public void save(Todo todo) {
        int id=0;
        if(todoList.size()>0){
            id = todoList.get(todoList.size()-1).getId()+1;
        }
        todo.setId(id);
        todoList.add(todo);
    }

    public void delete(int id) {
//        for(int i = 0; i < todoList.size();i++){
//            if(todoList.get(i).getId()==id){
//                todoList.remove(i);
//                break;
//            }
//        }
        todoList = todoList.stream()
                .filter(todo -> todo.getId() != id)
                .collect(Collectors.toList());

    }
}
