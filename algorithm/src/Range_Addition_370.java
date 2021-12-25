/*
use array to keep the change of current index and next index
diff[i] = arr[i] - arr[i - 1];
*/

public class Range_Addition_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length + 1];
        for (int[] row : updates) {
            int start = row[0];
            int end = row[1];
            int val = row[2];
            diff[start] += val;
            diff[end + 1] -= val;
        }
        int[] res = new int[length];
        int cur = 0;
        for (int i = 0; i < res.length; i++) {
            cur += diff[i];
            res[i] = cur;
        }
        return res;
    }
}
