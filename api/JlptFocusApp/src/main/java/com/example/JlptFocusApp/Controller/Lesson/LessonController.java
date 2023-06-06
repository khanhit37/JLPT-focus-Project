package com.example.JlptFocusApp.Controller.Lesson;

import com.example.JlptFocusApp.Entity.DTO.LessonWithTest2DTO;
import com.example.JlptFocusApp.Entity.DTO.LessonWithVocabulary2DTO;
import com.example.JlptFocusApp.Entity.Lesson.Lesson;
import com.example.JlptFocusApp.Entity.Test.Test2;
import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;
import com.example.JlptFocusApp.Service.Lesson.LessonService;
import com.example.JlptFocusApp.Service.Test.Test2Service;
import com.example.JlptFocusApp.Service.Vocabulary.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    VocabularyService vocabularyService;
    @Autowired
    Test2Service test2Service;
    @Autowired
    LessonService lessonService;


    @GetMapping("/level2/test/{id}")
    public LessonWithTest2DTO getLessonWithTestById(@PathVariable("id") Long id) {
        Lesson lesson = lessonService.findById(id);
        List<Test2> test2s = test2Service.findByLessonId(lesson.getId());

        LessonWithTest2DTO result = new LessonWithTest2DTO();

        result.setTest2s(test2s);

        return result;
    }

    @GetMapping("/level2/vocab/{id}")
    public LessonWithVocabulary2DTO getVocabularyByLessonId(@PathVariable("id") Long id) {
        Lesson lesson = lessonService.findById(id);

        List<Vocabulary2> vocabularies = vocabularyService.findByLessonId(lesson.getId());
        LessonWithVocabulary2DTO result = new LessonWithVocabulary2DTO();
        result.setVocabulary2s(vocabularies);

        return result;
    }


}
