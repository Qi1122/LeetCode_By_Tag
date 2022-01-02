/*
https://leetcode.com/problems/group-anagrams/
 */
import java.util.*;

public class String_Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //findAna return Key,找代表
            String ana = findAnagrams(str);
            // if (map.containsKey(ana)) map.get(ana).add(str);
            // else {
            //     map.put(ana, new ArrayList<String>());
            //     map.get(ana).add(str);
            // }
            if (!map.containsKey(ana)) map.put(ana, new ArrayList<String>());
            map.get(ana).add(str);
        }
        // List<List<String>> res = new ArrayList<>();
        // for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        //     res.add(entry.getValue());
        // }
        // return res;
        return new ArrayList(map.values());
    }
    //find 代表，字符串排序
    private String findAnagrams(String str) {
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }
}
