package in.himtech.learn.dockspring.jdbcclient.constant;

public class SqlStatement {

    public static final String INSERT_COURSE = """
                insert into course (name, author) 
                    values (?, ?)
            """;

    public static final String UPDATE_COURSE = """
                update course set name=?, author=?
                    where id=?
            """;

    public static final String GET_ALL_COURSE = """
                select id, name, author from course
            """;

    public static final String GET_COURSE_BY_ID = """
                select id, name, author from course 
                    where id = :id
            """;

    public static final String DELETE_COURSE_BY_ID = """
                delete from course 
                    where id = :id
            """;

    public static final String LAST_SAVED_COURSE = """
                select id, name, author from course 
                    where id = (select max(id) from course)
            """;

}
