package in.himtech.learn.dockspring.restclient.repository;

import in.himtech.learn.dockspring.restclient.constant.SqlStatement;
import in.himtech.learn.dockspring.restclient.model.Course;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    private JdbcClient jdbcClient;

    public CourseRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Course> findAllcourses() {
        return this.jdbcClient
                .sql(SqlStatement.GET_ALL_COURSE)
                .query(Course.class)
                .list();
    }

    public Optional<Course> findCourseById(Integer id) {
        return this.jdbcClient
                .sql(SqlStatement.GET_COURSE_BY_ID)
                .param("id", id)
                .query(Course.class)
                .optional();
    }

    public void saveCourse(Course course) {
        var affectedRow = this.jdbcClient
                    .sql(SqlStatement.INSERT_COURSE)
                            .params(course.getName(), course.getAuthor())
                                    .update();

        Assert.state(affectedRow == 1, "Failed to insert course " + course.getName());
    }

    public void updateCourse(Course course) {
        var affectedRow = this.jdbcClient
                    .sql(SqlStatement.UPDATE_COURSE)
                            .params(course.getName(), course.getAuthor(), course.getId())
                                    .update();

        Assert.state(affectedRow == 1, "Failed to update course " + course.getName());
    }

    public void deleteCourse(Course course) {
        var affectedRow = this.jdbcClient
                        .sql(SqlStatement.DELETE_COURSE_BY_ID)
                                .params("id", course.getId())
                                        .update();

        Assert.state(affectedRow == 1, "Failed to delete course " + course.getName());
    }

    public Course getLastSavedRecord() {
        return this.jdbcClient
                .sql(SqlStatement.LAST_SAVED_COURSE)
                .query(Course.class)
                .single();
    }
}
