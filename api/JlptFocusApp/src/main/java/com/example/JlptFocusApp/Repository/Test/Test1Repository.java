package com.example.JlptFocusApp.Repository.Test;

import com.example.JlptFocusApp.Entity.Test.Test1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test1Repository extends JpaRepository<Test1,Long> {
}
