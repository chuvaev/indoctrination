package com.ilyachuvaev.indoctrination.controller;

import com.ilyachuvaev.indoctrination.entity.Course;
import com.ilyachuvaev.indoctrination.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course/")
public class CourseController {

  private final CourseService service;

  @GetMapping("/course/{courseId}")
  public Course getCourseById(@PathVariable Long courseId){
    return service.getById(courseId);
  }

  @PostMapping("/course")
  public Course addCourse(@RequestBody Course theCourse){
    return service.saveOrUpdate(theCourse);
  }

  @PutMapping(value = "/course", consumes = {MediaType.APPLICATION_JSON_VALUE})
  public Course updateCourse(@RequestBody Course theCourse){
    return service.saveOrUpdate(theCourse);
  }

  @DeleteMapping("/course/{courseId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Long deleteCourse(@PathVariable Long courseId){
    service.delete(courseId);
    return courseId;
  }

}
