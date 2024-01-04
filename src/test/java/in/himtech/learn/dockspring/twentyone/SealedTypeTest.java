package in.himtech.learn.dockspring.twentyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SealedTypeTest {

    // The implementation class of sealed interface or class must be final. These classes could not be extended further.
    // When permit clause is added, it only allows those class to implements/extends with is listed in permit.
    // The sealed interface only permit Cat and Dog class to implements it. Bird class will throw error as it is not permitted.
    sealed interface Animal permits Cat, Dog {}

    final class Cat implements Animal{

        String meow(){
            return "Meow";
        }
    }

    final class Dog implements Animal{

        String bark(){
            return "Woof";
        }
    }

    // Java 21 way
    // The compiler convert the implementations of sealed interface to Enum
    String communicate(Animal animal){
        return switch(animal){
            case Cat cat-> cat.meow();
            case Dog dog -> dog.bark();
        };
    }

    //Java 17 way
    String classicCommunicate (Animal animal){
        var message = "";
        if(animal instanceof Dog dog) {
            message = dog.bark();
        }
        if(animal instanceof Cat cat) {
            message = cat.meow();
        }
        return message;
    }

    // 'Bird' is not allowed in the sealed hierarchy. It will throw error.
//    class Bird implements Animal{
//
//        String meow(){
//            return "Meow";
//        }
//    }

    @Test
    void testCommunicate(){
        Assertions.assertEquals(this.communicate(new Dog()), "Woof");
        Assertions.assertEquals(this.communicate(new Cat()), "Meow");
    }
}
