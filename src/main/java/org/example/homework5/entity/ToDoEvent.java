package org.example.homework5.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "event")
public class ToDoEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    private OffsetDateTime createdAt;

    public ToDoEvent(String eventName, OffsetDateTime createdAt) {
        this.eventName = eventName;
        this.createdAt = createdAt;
    }
}