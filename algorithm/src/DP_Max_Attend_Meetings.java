package algorithm.src;

/*
1. can attend the meeting has the earliest ending time

dp[i] -> max meeting can attend from 0 to i

AT dp[i], two options:
1. NOT attend i: dp[i - 1] -> total max meeting attend without attend i meeting
   dp[i] = dp[i - 1]
2. attend i: 1(cur meeting) + dp[j]
dp[j]: 在[0,j]中，可参加的max meeting

dp[i] = Max(option1, option2)

turn to binary search -> find j -> find end time < meeting i[0] (i's start time) -> find 1st location > i

X -> max meetings can be attended before i + current meeting i
because i - 1 meeting may not be attended
 */

import java.util.Arrays;

public class DP_Max_Attend_Meetings {
    private int res = 0;

    public int maxMeeting(int[] start, int[] end) {
        int totalMettings = start.length;
        int[][] arr = new int[totalMettings][2];
        for (int i = 0; i < totalMettings; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]); //sort by end time
        int[] dp = new int[totalMettings];
        //at index 0 -> only one meeting -> can attend -> dp[0] = 1
        dp[0] = 1;
        for (int i = 1; i < totalMettings; i++) {
            int startTime = arr[i][0];
            //int dpj = dp[insertIndex - 1];
            //insertIndex == 0 ? 0 : dpj
            //NOT attend
            int maxMeetingIfNOTAttendMeetingI = dp[i - 1];
            //Attend
            int maxMeetingIfAttendMeetingI;
            //index: the first meeting, which endTime > meeting i[startTime]
            //index是结束时间 > 当前meeting的开始时间的第一个meeting -> dp[index - 1] = dp[j]
            int index = binarySearch(arr, startTime);
            if (index == 0) maxMeetingIfAttendMeetingI = 0; //check 0 -> IOB
            else maxMeetingIfAttendMeetingI = dp[index - 1]; //dp[j]
            //dp function
            dp[i] = Math.max(maxMeetingIfNOTAttendMeetingI, maxMeetingIfAttendMeetingI + 1);
            //dp[i] = Math.max(dp[i - 1], 1 + (insertIndex == 0 ? 0 : dp[insertIndex - 1]));
        }
        return dp[totalMettings - 1];
    }
    //return index to incert i
    //return index of the first meeting started earlier than i
    private int binarySearch(int[][] arr, int startTime) {
        int left = 0;
        int right = arr.length; //need to insert one -> need extra one spot
        while (left + 1 < right) {
            //mid is index
            int mid = left + (right - left) / 2;
            if (arr[mid][1] > startTime) right = mid;
            else if (arr[mid][1] <= startTime) left = mid;
        }
        if (arr[left][1] > startTime) return left;
        else return right;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1, 1, 2, 2};
        int[] end = new int[]{3, 2, 4, 3};
        DP_Max_Attend_Meetings sol = new DP_Max_Attend_Meetings();
        System.out.println(sol.maxMeeting(start, end));
    }
}
