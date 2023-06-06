package com.example.JlptFocusApp.Repository.Test;

import com.example.JlptFocusApp.Entity.Test.Test3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test3Repository extends JpaRepository<Test3,Long> {
}
