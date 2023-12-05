package algorithm.src;

public class test {
    public static void main(String[] args) {
//        int[] a = {};
//        int b = 5;
//        System.out.println(Math.max(a[0], b));
        test sol = new test();
        int[] nums1 = {};
        int[] nums2 = {2};
        double a = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println(a);
        System.out.println(nums1.length);
 //       System.out.println(nums1[0]);
        //System.out.println(Math.max(nums1[0], nums2[0]));
        Math.max(nums1[0], nums2[0]);
     }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        //odd
        if ((l1 + l2) % 2 == 1) return findKthElement(nums1, 0, nums2, 0, (l1 + l2) / 2 + 1);
            //even
        else return (findKthElement(nums1, 0, nums2, 0, (l1 + l2) / 2 + 1)
                + findKthElement(nums1, 0, nums2, 0, (l1 + l2) / 2)) / 2;
    }
    //find kth smallest element
    //start: starting index
    private double findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        //corner case:
        //start index is passed the length of 1st array -> result must in at array 2
        //reduce offset
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
        //k is the smallest -> 搜最小的
        //base case:
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int nums1Mid = Integer.MAX_VALUE;
        int nums2Mid = Integer.MAX_VALUE;
        // binary search, size down
        if (start1 + k / 2 - 1 < nums1.length) nums1Mid = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) nums2Mid = nums2[start2 + k / 2 - 1];
        // k - k/2
        //there are k-1 elements before index k,
        //nums1Mid < nums2Mid -> no result start1 ~ start1 + k / 2 - 1
        //impossible in array 1
        if (nums1Mid < nums2Mid) return findKthElement(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        else return findKthElement(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
