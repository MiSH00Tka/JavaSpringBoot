package org.example.homework5.controller;


import lombok.RequiredArgsConstructor;
import org.example.homework5.controller.dto.ToDoListDTO;
import org.example.homework5.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService todoService;

    @PostMapping("/lists")
    public void saveToDoList(@RequestBody ToDoListDTO request) {
        todoService.saveToDoList(request);
    }

    @GetMapping("/lists")
    public List<ToDoListDTO> getAllToDoLists() {
        return todoService.getAllToDoLists();
    }
}
