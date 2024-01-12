package in.himtech.learn.dockspring.amqp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer id;
    private String name;
    private String department;
}
