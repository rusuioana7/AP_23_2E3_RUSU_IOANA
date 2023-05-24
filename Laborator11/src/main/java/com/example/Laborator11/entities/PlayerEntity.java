package com.example.Laborator11.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "players", schema = "public")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true, length = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


