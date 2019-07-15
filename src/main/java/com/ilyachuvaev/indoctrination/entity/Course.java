package com.ilyachuvaev.indoctrination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue
  @Column(name = "course_id", unique = true)
  private int id;
  @Column(name = "name")
  private String name;
}
