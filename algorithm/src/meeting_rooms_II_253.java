/*
link: https://leetcode.com/problems/meeting-rooms-ii/
1. create a list to store result
   create int count/result to store result
2. iterate input array, store each element to new list as result[][1]/result[][-1]
   "1" -> a start time
   "-1" -> an end time
3. sort list
    Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
4. iterate list to increment/decrement count, the point while max count is minimum rooms needed
Math.max(count, result)
 */
import java.lang.*;
import java.util.*;

public class meeting_rooms_II_253 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0;
        int count = 0;
        for (int[] point : list) {
            count += point[1];
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        meeting_rooms_II_253 solution = new meeting_rooms_II_253();
        int[][] intervals = { {0,30},{5,10},{15,20}};
        //solution.canAttendMeetings(intervals);
        System.out.println(solution.minMeetingRooms(intervals));
    }
}
