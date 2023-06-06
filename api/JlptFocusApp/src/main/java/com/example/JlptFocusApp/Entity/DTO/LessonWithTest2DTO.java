package com.example.JlptFocusApp.Entity.DTO;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import com.example.JlptFocusApp.Entity.Test.Test2;
import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LessonWithTest2DTO {
    private List<Test2> test2s;


}

