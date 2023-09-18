package com.training.courseservice.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.courseservice.intercomm.StudentClient;
import com.training.courseservice.model.Course;
import com.training.courseservice.model.Student;
import com.training.courseservice.repository.CourseRepository;

@RestController   //combination of @Controller and @ResponseBody
@RequestMapping("/courapi")
public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentClient studClient;
	
	@GetMapping("/cour")//("/cour/{id}")
	public ResponseEntity<List<Course>>  getCourses(){
		List<Course> courseList = repository.findAll();
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
//	public Course getStudById(@PathVariable("id") long id) {
//		Optional<Course> course = repository.findById(id);
//		
//		if(course.isPresent())
//		{
//			return course.get();
//		}
//		else {
//			return null;
//		}
//	}
	@ResponseBody
	public List<Course> getCour() {
		//return repository.findAll();
	
	List<Course> courseList = new ArrayList<>();
	courseList.add(new Course("C++",4,"A+"));
	courseList.add(new Course("Java",3,"A+"));
	courseList.add(new Course("DSA",3,"A"));
	courseList.add(new Course("DSP",4,"A"));
	return courseList;
	}
	
//	@PostMapping("/post")
//	public void post(@RequestBody Course course) 
//	{
//		repository.save(course);
//	}
	
	@PostMapping("/post")
	public ResponseEntity addCourse(@RequestBody Course course) 
	{
		return new ResponseEntity(repository.save(course),HttpStatus.CREATED);
	}
	
	@GetMapping("service/stud/{studId}")
	public Student getStud(@PathVariable int studId) {
		return studClient.getStudent(studId);
		
	}
	
	//@GetMapping("/service/cour/{courcourseId")
//	@PutMapping("/cour/{id}")
//	public void updateUser(@PathVariable("id") long id, @RequestBody Course course) {
//		Optional<Course> oldData = repository.findById(id);
//		if(oldData.isPresent()) {
//			Course cou= oldData.get();
//			cou.setCreditNo(course.getCreditNo());
//			cou.setGrade(course.getGrade());
//			cou.setCourseName(course.getCourseName());
//			repository.save(cou);
//		}
//		else {
//			System.out.println("No data found");
//		}
//	}
	
}


