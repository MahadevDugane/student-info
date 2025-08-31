package com.example.studentInfo.repository;
import com.example.studentInfo.bean.StudentRank;
import com.example.studentInfo.bean.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    @Query(value = "select id,standard,name from students s1 where marks = (select max(marks) from students s2 where s1.standard=s2.standard) ",nativeQuery = true)
    public List<StudentRank> getStudentRank();
}
