package com.practice.SpringCrud.Student;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
@Autowired
 private  StudentRepository studentrepository;

public StudentService(StudentRepository studentrepository) {
	super();
	this.studentrepository = studentrepository;
}
    public List<Student> getAll(){
    	return studentrepository.findAll();
    }
    public Student getByStudentId(int id) {
		Optional<Student> optional= studentrepository.findById(id);
		Student student=null;
		if(optional.isPresent()) {
			student=optional.get();
			
		}else {
			throw new ArrayIndexOutOfBoundsException("id not present");
		}
	
	return student;
	}
    public Student addStudent(Student student) {
    	return studentrepository.save(student);
    }
    public void updateById(Student student) {
    	studentrepository.save(student);
    }
    public void deleteById(int id) {
    	studentrepository.deleteById(id);
    }
	}

