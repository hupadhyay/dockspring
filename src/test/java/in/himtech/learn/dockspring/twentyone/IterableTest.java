package in.himtech.learn.dockspring.twentyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IterableTest {

    record Employee(String name, String company){};

    @Test
    public void testArrayList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Rakesh", "L&T"));

        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("Rakesh", "L&T"));
        System.out.println(list2);

        Assertions.assertIterableEquals(list, list2);
    }

//    @Test
//    public void testArrayListFailure(){
//        Assertions.fail("Not yet implemented");
//    }
}
