package br.com.ourtest.mycoses.controller;

import br.com.ourtest.mycoses.model.Course;
import br.com.ourtest.mycoses.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Cursos")
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @ApiOperation(value = "Obetendo lista de cursos")
    @GetMapping(path = "/list")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @ApiOperation(value = "Salvando um novo curso")
    @PostMapping(path = "/save")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        Course newCourse = service.save(course);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    @ApiOperation(value = "Atualizando um curso")
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable Long id) {
        Course newCourse = service.update(course, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    @ApiOperation(value = "Atualizando nome de um curso")
    @PatchMapping(path = "/update/{id}/{name}")
    public ResponseEntity<Course> update(@PathVariable Long id, @PathVariable String name) {
        Course newCourse = service.updatePatch(id, name);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    @ApiOperation(value = "Deletando um curso")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}