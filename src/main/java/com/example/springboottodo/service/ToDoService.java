package com.example.springboottodo.service;

import com.example.springboottodo.beans.ToDo;
import com.example.springboottodo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> toDoList = new ArrayList<>();

    static {
        toDoList.add(new ToDo(1, "root", "Learn Spring", LocalDate.now().plusYears(1), false));
        toDoList.add(new ToDo(2, "root", "Learn SpringBoot", LocalDate.now().plusYears(2), false));
        toDoList.add(new ToDo(1, "a", "Learn React", LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUserName(String userName) {
        List<ToDo> temp = new ArrayList<>();
        for (ToDo user : toDoList) {
            if (Objects.equals(userName, user.getUsername())) {
                temp.add(user);
            }
        }
        return temp;
    }

    public int findToDoCount(String userName) {
//        List<ToD> tempList;
//        tempList = findByUserName(userName);
//        return tempList.size()+1;
        ToDo last = toDoList.get(toDoList.size() - 1);
        return last.getId() + 1;
    }

    public void addNewEntryToList(String username, String description, LocalDate date) {
        toDoList.add(new ToDo(findToDoCount(username), username, description, date, false));
    }

    public void deleteToDo(int id) {
        toDoList.removeIf(user -> user.getId() == id);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        return toDoList.stream().filter(predicate).findFirst().get();
    }

    public void updateToDo(int id, String name, String description, LocalDate targetDate) {
        for (ToDo user : toDoList) {
            if (user.getId() == id) {
                user.setDescription(description);
                user.setTargetDate(targetDate);
            }
        }
    }
}
