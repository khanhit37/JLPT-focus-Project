package com.example.JlptFocusApp.Entity.Grammar;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "grammar2")
@AllArgsConstructor
@NoArgsConstructor
public class Grammar2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String structure;

    private String mean;

    private String example;


    @ManyToOne
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;
}
