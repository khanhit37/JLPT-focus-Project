package com.example.JlptFocusApp.Service.Vocabulary;

import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;

import java.util.List;

public interface VocabularyService {

    List<Vocabulary2> findByLessonId(Long id);
}
