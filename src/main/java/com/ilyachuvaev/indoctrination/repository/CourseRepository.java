package com.ilyachuvaev.indoctrination.repository;

import com.ilyachuvaev.indoctrination.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
