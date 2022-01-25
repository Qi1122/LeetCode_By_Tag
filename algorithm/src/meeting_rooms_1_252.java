/*
https://leetcode.com/problems/meeting-rooms/
1.sort input intervals
2. if (intervals[i][1] > intervals[i + 1][0]) -> false
 */

import java.lang.*;
import java.util.*;

public class meeting_rooms_1_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        meeting_rooms_1_252 solution = new meeting_rooms_1_252();
        int[][] intervals = { {0,30},{5,10},{15,20}};
        //solution.canAttendMeetings(intervals);
        System.out.println(solution.canAttendMeetings(intervals));
    }
}
