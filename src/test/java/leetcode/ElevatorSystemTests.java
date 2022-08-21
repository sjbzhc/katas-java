package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ElevatorSystemTests {
    @Test
    public void test() {
        ElevatorSystem es = new ElevatorSystem(0);

        ElevatorSystem.Request r1 = new ElevatorSystem.Request(0, 10, ElevatorSystem.Direction.IDLE, ElevatorSystem.Location.OUTSIDE_ELEVATOR);
        ElevatorSystem.Request r2 = new ElevatorSystem.Request(1, 7, ElevatorSystem.Direction.UP, ElevatorSystem.Location.OUTSIDE_ELEVATOR);
        ElevatorSystem.Request r3 = new ElevatorSystem.Request(1, 3, ElevatorSystem.Direction.UP, ElevatorSystem.Location.INSIDE_ELEVATOR);
        ElevatorSystem.Request r4 = new ElevatorSystem.Request(3, -1, ElevatorSystem.Direction.UP, ElevatorSystem.Location.INSIDE_ELEVATOR);
        ElevatorSystem.Request r5 = new ElevatorSystem.Request(4, 11, ElevatorSystem.Direction.UP, ElevatorSystem.Location.INSIDE_ELEVATOR);

        es.sendUpRequest(r1);
        es.sendUpRequest(r2);
        es.sendUpRequest(r3);
        es.sendDownRequest(r4);
        es.sendDownRequest(r5);

        es.run();
    }
}
