package algorithm.src;/*
https://leetcode.com/problems/group-anagrams/

1. create hashmap : key -> sorted anagram, value -> list of words has the same anagram
2. how to sort anagram:
    -> char[] c = string.toCharArray() //convert to char[]
    -> Arrays.sort(c)
    -> str = String.valueOf(c) // convert to String again

findAna return Key -> 找代表

             if (map.containsKey(ana)) map.get(ana).add(str);
             else {
                 map.put(ana, new ArrayList<String>());
                 map.get(ana).add(str);
             }


         List<List<String>> res = new ArrayList<>();
             for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                 res.add(entry.getValue());
         }
         return res;

        -> method:  find 代表，字符串排序

 */
import java.util.*;

public class String_Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String anagram = findAnagrams(str);
            if (!map.containsKey(anagram)) map.put(anagram, new ArrayList<String>());
            map.get(anagram).add(str);
        }
        return new ArrayList(map.values());
    }

    private String findAnagrams(String str) {
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }
}
