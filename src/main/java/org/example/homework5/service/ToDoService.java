package org.example.homework5.service;

import lombok.RequiredArgsConstructor;
import org.example.homework5.controller.dto.ToDoListDTO;
import org.example.homework5.entity.ToDoEvent;
import org.example.homework5.entity.ToDoList;
import org.example.homework5.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoListRepository repository;

    public void saveToDoList(ToDoListDTO request) {
        List<ToDoEvent> events = request.events().stream()
                .map(eventName -> new ToDoEvent(eventName, OffsetDateTime.now())).toList();
        repository.save(new ToDoList(request.name(), events, OffsetDateTime.now()));
    }

    public List<ToDoListDTO> getAllToDoLists() {
        List<ToDoListDTO> toDoLists = new ArrayList<>();
        List<ToDoList> lists = repository.findAll();

        for (ToDoList list : lists) {
            List<String> events = list.getEvents().stream().map(ToDoEvent::getEventName).toList();
            toDoLists.add(new ToDoListDTO(list.getListName(), events));
        }

        return toDoLists;
    }
}
