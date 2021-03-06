/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Remove_Duplicates_From_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
