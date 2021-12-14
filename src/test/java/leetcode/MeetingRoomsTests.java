package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MeetingRoomsTests {
    @Test
    public void meeting_rooms() {
        MeetingRooms mr = new MeetingRooms();
        int[] i1 = {0,30};
        int[] i2 = {5,10};
        int[] i3 = {15,20};
        int[][] intervals = {i1, i2, i3};

        Assertions.assertThat(mr.minMeetingRooms(intervals)).isEqualTo(2);
    }

    @Test
    public void meeting_rooms_prio_queue() {
        MeetingRooms mr = new MeetingRooms();
        int[] i1 = {0,30};
        int[] i2 = {5,10};
        int[] i3 = {15,20};
        int[][] intervals = {i1, i2, i3};

        Assertions.assertThat(mr.minMeetingRoomsPriorityQueue(intervals)).isEqualTo(2);
    }

    @Test
    public void meeting_rooms_2() {
        MeetingRooms2 mr = new MeetingRooms2();
        int[] i1 = {0,30};
        int[] i2 = {5,10};
        int[] i3 = {15,20};
        int[][] intervals = {i1, i2, i3};

        Assertions.assertThat(mr.minMeetingRoomsPriorityQueue(intervals)).isEqualTo(2);
    }
}
