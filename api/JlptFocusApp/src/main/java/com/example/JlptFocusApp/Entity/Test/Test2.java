package com.example.JlptFocusApp.Entity.Test;



import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "test2")
@AllArgsConstructor
@NoArgsConstructor

public class Test2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String select1;
    private String select2;
    private String select3;
    private String select4;
    private String answer;
    @OneToOne
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;





}
