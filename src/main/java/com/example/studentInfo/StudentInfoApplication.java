package com.example.studentInfo;

import com.example.studentInfo.bean.Students;
import com.example.studentInfo.repository.StudentRepository;
import com.example.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
@EnableCaching
public class StudentInfoApplication  {
 	@Autowired
	StudentRepository repo;
	public static void main(String[] args) {

		SpringApplication.run(StudentInfoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		StudentInfoService service = new StudentInfoService(repo);
//		Students student = new Students(2,"Mahadev","Fisrt",81);
//		service.saveDetails(student);
//	}
}
