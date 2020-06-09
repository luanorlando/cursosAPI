package br.com.ourtest.mycoses.repository;

import br.com.ourtest.mycoses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
