package br.com.ourtest.mycoses.service;

import br.com.ourtest.mycoses.model.Course;
import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<Course> findAll();

    Course update (Course course, Long id);

    void delete(Long id);

    Course updatePatch(Long id, String name);
}
