/*
https://leetcode.com/problems/merge-sorted-array/
 */
public class Merge_Sorted_Array_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];
        int nums1Index = 0;
        int nums2Index = 0;
        int resultIndex = 0;
        while ((nums1Index < m) && (nums2Index < n)) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                result[resultIndex++] = nums1[nums1Index++];
            } else {
                result[resultIndex++] = nums2[nums2Index++];
            }
        }
        while (nums1Index < m) {
            result[resultIndex++] = nums1[nums1Index++];
        }
        while (nums2Index < n) {
            result[resultIndex++] = nums2[nums2Index++];
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }
}
