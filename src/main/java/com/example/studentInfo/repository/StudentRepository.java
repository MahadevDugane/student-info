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

    @Query(value = "select id,standard,marks,name from (\n" +
            "select id,standard,marks,name,  ROW_NUMBER() over( partition by standard order by marks desc ) as rank_std from sys.student) ranking where rank_std<=3  ; ",nativeQuery = true)
    public List<StudentRank> getStudentRank();
}
