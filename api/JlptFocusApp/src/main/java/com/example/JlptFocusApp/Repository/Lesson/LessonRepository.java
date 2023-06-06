package com.example.JlptFocusApp.Repository.Lesson;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
