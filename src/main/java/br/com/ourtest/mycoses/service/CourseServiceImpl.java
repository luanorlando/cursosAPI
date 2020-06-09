package br.com.ourtest.mycoses.service;

import br.com.ourtest.mycoses.model.Course;
import br.com.ourtest.mycoses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public Course save(Course course) {
        Course savedCourse = repository.save(course);

        return savedCourse;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = repository.findAll();

        return courses;
    }

    @Override
    public Course update(Course course, Long id) {

        return repository.findById(id)
                .map(courseMapped -> {
                    courseMapped.setName(course.getName());
                    courseMapped.setNivel(course.getNivel());
                    return repository.save(courseMapped);
                })
                .orElseGet(() -> {
                    course.setId(id);
                    return repository.save(course);
                });

    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Course updatePatch(Long id, String name) {

        return repository.findById(id)
                .map(courseMapped -> {
                    courseMapped.setName(name);
                    return repository.save(courseMapped);
                })
                .orElseGet(() -> {
                    Course course = new Course();
                    course.setId(id);
                    course.setName(name);
                    course.setNivel("Basico");
                    return repository.save(course);
                });
    }
}
