package com.example.JlptFocusApp.Entity.Vocabulary;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vocabulary1")
@AllArgsConstructor
@NoArgsConstructor
public class Vocabulary1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kanji;

    private String furigana;

    private String mean;


    @ManyToOne
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;

}
