package in.himtech.learn.dockspring.restclient.service;

import in.himtech.learn.dockspring.restclient.model.Course;
import in.himtech.learn.dockspring.restclient.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return this.courseRepository.findAllcourses();
    }

    public Course getCourseById(Integer id) {
        Optional<Course> optionalCourse = this.courseRepository.findCourseById(id);
        return optionalCourse.orElseThrow(IllegalArgumentException::new);
    }

    public Course saveCourse(Course course) {
        this.courseRepository.saveCourse(course);
        return this.courseRepository.getLastSavedRecord();
    }

    public Course updateCourse(Course course) {
        this.courseRepository.updateCourse(course);
        return getCourseById(course.getId());
    }

    public void deleteCourse(Integer id) {
        Course course = this.getCourseById(id);
        this.courseRepository.deleteCourse(course);
    }
}
