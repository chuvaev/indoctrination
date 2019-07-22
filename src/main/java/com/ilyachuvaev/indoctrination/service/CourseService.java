package com.ilyachuvaev.indoctrination.service;

import com.ilyachuvaev.indoctrination.entity.Course;
import com.ilyachuvaev.indoctrination.exception.CourseNotFoundException;
import com.ilyachuvaev.indoctrination.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.CheckedOutputStream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {

  private final CourseRepository repository;
  private final int size = 6;

  public Course getById(Long id){
    Optional<Course> course = repository.findById(id);
    return course.orElseThrow(() -> new CourseNotFoundException("Course with id=" + id + " not found!"));
  }

  public Course saveOrUpdate(Course course){
    if(course != null){
      repository.save(course);
    } else {
      throw new CourseNotFoundException("Course not found!!!");
    }
    return course;
  }

  public long delete(Long id){
    Optional<Course> course = repository.findById(id);
    course.ifPresentOrElse(
        v -> repository.deleteById(id),
        () -> new CourseNotFoundException("Course with id="+ id + " not found!")
    );
    return id;
  }

  public List<Course> getCourses(){
    List<Course> courses = new ArrayList<>(size);
    courses.addAll(getAllCourses());
    return courses;
  }

  private List<Course> getAllCourses(){return (List<Course>) repository.findAll();}
}
