package in.himtech.learn.dockspring.twentyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class EnhanceSwitchTest {

    // Example of classic switch example
    int calculateTimeOffClassic(DayOfWeek dayOfWeek){
        var timeOff = 0;
        switch (dayOfWeek){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY:
                timeOff = 16;
                break;
            case FRIDAY:
                timeOff = 20;
                break;
            case SATURDAY, SUNDAY:
                timeOff = 24;
                break;
        }
        return timeOff;
    }

    // Example of enhancedSwith
    int calculateTimeOff(DayOfWeek dayOfWeek){
        return switch (dayOfWeek){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> 16;
            case FRIDAY -> 20;
            case SATURDAY, SUNDAY -> 24;
        };
    }

    @Test
    void testCalculateTimeOff(){
        Assertions.assertEquals(this.calculateTimeOff(DayOfWeek.FRIDAY), 20);
        Assertions.assertEquals(this.calculateTimeOff(DayOfWeek.SUNDAY), 24);
        Assertions.assertEquals(this.calculateTimeOff(DayOfWeek.MONDAY), 16);
    }
}
