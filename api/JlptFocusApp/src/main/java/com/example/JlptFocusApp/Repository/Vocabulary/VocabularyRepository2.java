package com.example.JlptFocusApp.Repository.Vocabulary;

import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary1;
import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public interface VocabularyRepository2 extends JpaRepository<Vocabulary2, Long> {

    List<Vocabulary2> findByLessonId(Long id);
}
