package com.example.JlptFocusApp.Repository.Test;

import com.example.JlptFocusApp.Entity.Test.Test2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Test2Repository extends JpaRepository<Test2, Long> {

    List<Test2> findByLessonId(Long id);
}
