package com.example.JlptFocusApp.Entity.DTO;

import com.example.JlptFocusApp.Entity.Vocabulary.Vocabulary2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonWithVocabulary2DTO {

    private List<Vocabulary2> vocabulary2s;
}
