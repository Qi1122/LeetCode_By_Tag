/*
https://leetcode.com/problems/maximum-units-on-a-truck/
 */

import java.util.*;

public class Max_Units_on_Truck_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int numOfBox = boxTypes[i][0];
            int numOfUnit = boxTypes[i][1];
            if (truckSize > numOfBox) {
                maxUnits += numOfBox * numOfUnit;
                truckSize -= numOfBox;
            } else {
                maxUnits += truckSize * numOfUnit;
                break;
            }
        }
        return maxUnits;
    }
}
