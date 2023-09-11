package com.example.demo5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    //Hien thi danh sách
    @GetMapping("/todos")
    public String getAllTodo(Model model){
        List<Todo> todoList = todoService.getAll();
        model.addAttribute("todoList",todoList);
        return "todo-app";




    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("todo",Todo.builder().build());
        return"addTodo";
    }
    @PostMapping ("/add")
    public String save(@ModelAttribute Todo todo){
        todoService.save(todo);
        return"redirect:/todos";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        todoService.delete(id);
        return"redirect:/todos";

    }
    @GetMapping("/update")
    public String update(Model model,@RequestParam int id){
        //Tìm id
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo );
        return "addTodo";


    }
}
