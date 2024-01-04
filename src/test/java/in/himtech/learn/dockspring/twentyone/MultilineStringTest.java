package in.himtech.learn.dockspring.twentyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultilineStringTest {

    // This feature is from Java 17 and onwards.

    @Test
    public void testMultiline() {
        // The sentence must be start from the next line of """
        var multiline = """  
               We are processing the check we recently received.
                            
               Generally, checks received before 6:30 pm Eastern Time (ET) on a business day 
                will be deposited into your account on the same day. Checks received on 
                a non-business day or after 6:30 pm ET on a business day will be deposited 
                the following business day. Once the check has been deposited, 
                you can log into your account to confirm when the funds will be available.
                            
               Remember to keep the check for at least two business days after 
                it has been deposited to your account before you shred it.
                """;

        Assertions.assertTrue(multiline.startsWith("We are"));
    }

    @Test
    public void StringStripTest(){

        var st1 = "    Hello Himanshu    ";
        // strip() truncate both side of spaces: leading and trailing
        Assertions.assertEquals(st1.strip(), "Hello Himanshu");

        Assertions.assertEquals(st1.stripLeading(), "Hello Himanshu    ");
        Assertions.assertNotEquals(st1.stripLeading(), "Hello Himanshu");

        Assertions.assertEquals(st1.stripTrailing(), "    Hello Himanshu");
        Assertions.assertNotEquals(st1.stripTrailing(), "Hello Himanshu");

    }
}
