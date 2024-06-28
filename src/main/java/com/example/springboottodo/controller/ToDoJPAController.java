package com.example.springboottodo.controller;

import com.example.springboottodo.beans.ToDo;
import com.example.springboottodo.repository.ToDoRepository;
import com.example.springboottodo.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoJPAController {
    private final ToDoRepository toDoRepository;

    public ToDoJPAController(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/list-todos")
    public String listALlToDOs(ModelMap modelMap){
        String name = getLoggedInUsername(modelMap);
        List<ToDo> todos = toDoRepository.findByUsername(name);
        modelMap.addAttribute("toDo",todos);
        return "listToDos";
    }
    @GetMapping("/add-todo")
    public String showNewToDoPage(ModelMap modelMap){
        String name = getLoggedInUsername(modelMap);
        ToDo toDo = new ToDo(0,name,"",LocalDate.now().plusYears(1),false);
        modelMap.put("toDo",toDo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewToDoPage(ModelMap modelMap, @Valid ToDo toDo, BindingResult result){
        if(result.hasErrors())
            return "todo";

        String name = getLoggedInUsername(modelMap);
        toDo.setUsername(name);
        toDoRepository.save(toDo);

        return "redirect:/list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteToDo(@RequestParam int id){
        toDoRepository.deleteById(id);
        return "redirect:/list-todos";
    }

    @GetMapping("/complete-todo")
    public String markToDoAsComplete(@RequestParam int id){
        ToDo toDo = toDoRepository.findById(id).get();
        toDo.setStatus(true);
        toDoRepository.save(toDo);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdatePage(@RequestParam int id,ModelMap modelMap){
        ToDo toDo = toDoRepository.findById(id).get();
        modelMap.put("toDo",toDo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result){
        if(result.hasErrors())
            return "todo";

        String name = getLoggedInUsername(modelMap);
        toDo.setUsername(name);
        toDoRepository.save(toDo);
        return "redirect:/list-todos";
    }

    private static String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
