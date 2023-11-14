package com.practice.SpringCrud.Student;



import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
