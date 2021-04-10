package com.cloud_project.demo.accessingmysql;

import org.springframework.data.repository.CrudRepository;

import com.cloud_project.demo.accessingmysql.Course;

public interface CourseRepo extends CrudRepository<Course, Integer>{

}
