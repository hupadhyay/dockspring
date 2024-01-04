package in.himtech.learn.dockspring.twentyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeContructionTest {

    record User(String userName, int userId){};
    record UserCreationEvent(String name){};
    record UserDeletionEvent(User user){};

    // In case statements, The object of UserCreationEvent and UserDeletionEvent has been deConstructed and its field value has been used.
    String userOperation(Object obj){
        return switch(obj){
            case UserCreationEvent  (var name) -> "User created with name " + name;
            case UserDeletionEvent (var user) -> "The user with name " + user.userName() + " has been deleted";
            default -> null;
        };
    }

    @Test
    void testUserOperation(){
        User user = new User("Himanshu", 101);
        UserCreationEvent creationEvent = new UserCreationEvent("Himanshu");
        UserDeletionEvent deletionEvent = new UserDeletionEvent(user);

        Assertions.assertEquals(this.userOperation(creationEvent), "User created with name Himanshu");
        Assertions.assertEquals(this.userOperation(deletionEvent), "The user with name Himanshu has been deleted");
    }
}
