package net.hari.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hari.exception.CustomExp;
import net.hari.model.Student;
import net.hari.repo.StudentRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;
	
	// get all student
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}		
	
	// create student rest api
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	// get student by id rest api
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new CustomExp("Student not exist with id :" + id));
		return ResponseEntity.ok(student);
	}
	
	// update student rest api
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new CustomExp("Student not exist with id :" + id));
		
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());
		
		Student updatedStudent = studentRepo.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	// delete student rest api
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new CustomExp("Student not exist with id :" + id));
		
		studentRepo.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}