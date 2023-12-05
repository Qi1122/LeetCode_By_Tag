/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

DFS
record current subset
at each level, determine the char at the position "index" to be picked or not

terminate condition:
when finishes determining for all the characters pick or not, we have a complete subset
1) not pick the char at index
2) pick the char at index
remember to remove the added char when back tracking to be previous level(吃吐原则)

 */
package algorithm.src;
import java.util.*;

public class DFS_All_Subsets_I {
    private List<String> res = new ArrayList<>();

    public List<String> findSets (String set) {
        if(set == null) return res;
        char[] arraySet = set.toCharArray(); //need index
        StringBuilder sb = new StringBuilder(); //string is immutable
        dfs(arraySet, 0, sb); //apply the same rule
        return res;
    }

    //do dfs to each element by using INDEX
    private void dfs(char[] input, int index, StringBuilder sb) {
        if (index == input.length) {
            res.add(sb.toString());
            return;
        }
        // + a
        sb.append(input[index]);
        dfs(input, index + 1, sb);
        // not + a
        sb.deleteCharAt(sb.length() - 1);
        //why increment index?? handle duplicate scenario
        //if (index + 1 < input.length && input[index] == input[index + 1]) index++;
        dfs(input, index + 1, sb);
    }

    public static void main(String[] args) {

    }
}
