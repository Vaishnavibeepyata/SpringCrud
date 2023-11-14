package com.practice.SpringCrud.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	@GetMapping("/student")
	ResponseEntity<List<Student>> get() {
		List<Student> student = studentservice.getAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("INFO", "getting list of all Students");
		return ResponseEntity.ok().headers(httpHeaders).body(student);
	}

	@GetMapping("/students")
	ResponseEntity<Student> getById(@RequestParam(value = "id") int id) {

		Student student = studentservice.getByStudentId(id);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("INFO", "getting only one Student from list");
		return ResponseEntity.accepted().headers(httpHeaders).body(student);

	}

	@PostMapping("/student")
	ResponseEntity<Student> add(@RequestBody Student student) {
		Student studentn = studentservice.addStudent(student);
		HttpHeaders httpHeader = new HttpHeaders();
		ResponseEntity<Student> responsentity = new ResponseEntity<>(studentn, httpHeader, HttpStatus.OK);
		httpHeader.add("info", "adding a new student to list");
		return responsentity;
	}

	@PutMapping("/student")
	public String updateBuId(@RequestBody Student student) {
		studentservice.updateById(student);
		return "updated succesfully";
	}

	@DeleteMapping("/student/{id}")
	public String deleteById(@PathVariable int id) {
		studentservice.deleteById(id);
		return "deleted succesfully";
	}

}
