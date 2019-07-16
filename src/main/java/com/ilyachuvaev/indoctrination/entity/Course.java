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
  private long id;
  @Column(name = "course_name")
  private String name;

  public long getId(){
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
