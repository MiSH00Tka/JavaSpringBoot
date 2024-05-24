package org.example.homework5.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "list")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String listName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private List<ToDoEvent> events;

    private OffsetDateTime createdAt;

    public ToDoList(String listName, List<ToDoEvent> events, OffsetDateTime createdAt) {
        this.listName = listName;
        this.events = events;
        this.createdAt = createdAt;
    }
}
