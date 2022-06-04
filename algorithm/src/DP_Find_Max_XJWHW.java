/*
n min -> arr len -> n
for i min -> Xi drones came (x1, x2 ...) -> drone frequency -> one per min
function f: j min pass -> reload -> destroy f(j) drone
kth min, j min pass -> destroy min(Xk, f(j)) -> totally dead

f(j)-> can destroy j drones
xi -> at i min, i drones came

j range:
k range:
dp[n]: max drones destroy at n min
dp[0]-> 0
dp[j]-> 1
dp[i]: max destroy j drones in i min
dp[i - 1]:

assumption:
1. totalUse > 0
2. j >= 0
total usage = 2
time = 5
reloadTime = 2

dp[i]: cur max shot
-> (j > 1) dp[i] = dp[i - 1]
-> (j = 1) dp[i] = dp[i - 1] + min(Xk, f(j))
dp[i - 1]
dp[i - j]

[0, j]

    0   1    2    3    4   5
             j
dp  0
    1

 */
package algorithm.src;

public class DP_Find_Max_XJWHW {
    private int lastStartTime = 0;

    private int findMax(int totalUse, int reloadTime, int time) {
        int count = 0;
        if (reloadTime > time) return count;
        int[] dp = new int[time]; //n ? k
        int curUse = 0;
        dp[0] = 0;
        dp[reloadTime] = 1;
        return count;
    }

    private int usageLeft(int totalUse, int curUse) {
        return totalUse - curUse;
    }
    //        if (curTime - lastStartTime >= 0) return true;
    //        else return false;

    //f(j) can destroy j drones in the j the use
    private void recharging(int reloadTime, int curTime, int curUse, int totalUse) {
        if (curUse > totalUse) return;

    }

    private void destroy(){

    }

    public static void main(String[] args) {
        DP_Find_Max_XJWHW sol = new DP_Find_Max_XJWHW();
        int totalUse = 5;
        int reloadTime = 2;
        int time = 5;
        int res = sol.findMax(totalUse, reloadTime, time);
        System.out.println(res);
    }
}
