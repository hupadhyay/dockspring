package in.himtech.learn.dockspring.restclient.controller;

import in.himtech.learn.dockspring.restclient.model.Course;
import in.himtech.learn.dockspring.restclient.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> listCourse =  this.courseService.getAllCourses();
        return new ResponseEntity<>(listCourse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
        Course course = this.courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        Course savedCourse = this.courseService.saveCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course updatedCourse = this.courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
            this.courseService.deleteCourse(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
