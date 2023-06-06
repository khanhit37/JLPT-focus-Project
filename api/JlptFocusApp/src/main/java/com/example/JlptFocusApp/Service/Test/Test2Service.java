package com.example.JlptFocusApp.Service.Test;

import com.example.JlptFocusApp.Entity.Test.Test2;
import com.example.JlptFocusApp.Repository.Test.Test2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test2Service {
    @Autowired
    Test2Repository test2Repository;
    public List<Test2> findByLessonId(Long id) {
        return test2Repository.findByLessonId(id);
    }
}
