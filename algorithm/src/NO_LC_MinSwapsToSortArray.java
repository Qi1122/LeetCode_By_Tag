package algorithm.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @projectName: CodeTest
 * @package: PACKAGE_NAME
 * @className: MinSwapToSortArray
 * @author: Caroline Sun
 * @description: TODO
 * @date: 12/5/23 1:16 PM
 * @version: 1.0
 * link: https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 * https://leetcode.com/discuss/general-discussion/1296769/min-no-of-swaps-to-sort-the-array-wrong-approach-vs-correct-approach
 */

public class NO_LC_MinSwapsToSortArray {
    public static void main(String[] args) {
        int[] input1 = {2, 8, 5, 4};    // 1
        int[] input2 = {2, 4, 5, 1, 3}; // 3
        int[] input3 = {1, 5, 4, 3, 2}; // 2
        int[] input4 = {4, 3, 2, 1};    // 2

        NO_LC_MinSwapsToSortArray sol = new NO_LC_MinSwapsToSortArray();
        //sol 1: use graph, better solution
        System.out.println(sol.minSwapsUseGraph(input1));
        System.out.println(sol.minSwapsUseGraph(input2));
        System.out.println(sol.minSwapsUseGraph(input3));
        System.out.println(sol.minSwapsUseGraph(input4));

        //Sol 2: Use swaps, not pass some hackrack
    }

    /**
     *
     * visualizing the problem as a graph.
     * We will have N nodes and an edge directed from node i to node j
     * if the element at the i’th index must be present at the j’th index in the sorted array.
     *
     * The graph will now contain many non-intersecting cycles.
     * Now a cycle with 2 nodes will only require 1 swap to reach the correct ordering,
     * similarly, a cycle with 3 nodes will only require 2 swaps to do so.
     *
     * Find circle and nodes
     *
     * [1, 5, 4, 3, 2]
     *  0  1  2  3  4
     *
     *  iteration index 0 1 2 3 4  i
     *     sorted value 1 2 3 4 5  matrix[i][0]
     *   original index 0 4 3 2 1  matrix[i][1]
     *
     *  Notice that the original index of current value, is the new index of iteration of next looking value
     */
    private int minSwapsUseGraph(int[] arr) {
        int minSwaps = 0;

        int[][] matrix = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            matrix[i][0] = arr[i];
            matrix[i][1] = i;
        }
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);

        List<Set<Integer>> cycles = new ArrayList<>();
        boolean[] visited = new boolean[arr.length]; //the index is the current visit index
        for (int i = 0; i < matrix.length; i++) { //matrix[i][0]]: value, matrix[i][1]]: next visit index
            if (!visited[i] && matrix[i][1] != i) { //not visited, skip if value is in correct position
                Set<Integer> set = new HashSet<>(); //create a new cycle
                dfs(matrix, set, visited, i);
                cycles.add(set);
            }
        }
        for (Set<Integer> set : cycles) minSwaps += set.size() - 1;
        return minSwaps;
    }

    private void dfs(int[][] matrix, Set<Integer> set, boolean[] visited, int index) {
        if (visited[index]) return;

        visited[index] = true;
        set.add(matrix[index][0]);
        dfs(matrix, set, visited, matrix[index][1]);
    }

    /**
     * [1, 5, 4, 3, 2]
     *  1  2  3  4  5
     *  matrix
     *  [1-0, 5-1, 4-2, 3-3, 2-4]
     *  sort matrix by matrix[i][0], which will make index to new order
     *  swap to make new matrix back to index order/original matrix order
     */
    private int minSwaps(int[] arr) {
        int minSwaps = 0;
        int[][] matrix = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            matrix[i][0] = arr[i];
            matrix[i][1] = i;
        }
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]); //comparator

        for (int i = 0; i < arr.length; i++) {
            if (matrix[i][1] == i) continue;
            else {
                swap(matrix, i, matrix[i][1]);
                minSwaps++;
                i--; //check again, if not match, swap again
            }
        }
        return minSwaps;
    }

    private void swap(int[][] arr, int a, int b) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

