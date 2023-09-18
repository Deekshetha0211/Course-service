package com.training.courseservice.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.courseservice.model.Student;

@FeignClient(name="student",url="http://localhost:8083")
public interface StudentClient {
	@PostMapping(value="/studapi/stud",consumes="application/json")
	Student getStudent(@RequestBody int studId);

}
