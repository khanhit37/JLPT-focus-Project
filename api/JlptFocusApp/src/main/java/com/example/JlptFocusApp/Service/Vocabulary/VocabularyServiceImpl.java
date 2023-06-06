package com.example.JlptFocusApp.Service.Vocabulary;

import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;
import com.example.JlptFocusApp.Repository.Vocabulary.VocabularyRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired
    VocabularyRepository2 vocabularyRepository2;


    @Override
    public List<Vocabulary2> findByLessonId(Long id) {
        return vocabularyRepository2.findByLessonId(id);
    }
}
