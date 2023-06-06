package com.example.JlptFocusApp.Service.Lesson;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import com.example.JlptFocusApp.Repository.Lesson.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository lessonRepository;


    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);

    }
}
