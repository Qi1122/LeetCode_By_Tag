/*
https://leetcode.com/problems/analyze-user-website-visit-pattern/

总结：type，记得存什么，String immutable！

1. List<Tuple> tuples -> set up data , sort by timestamp
2. put data in map: key: username, value : list<all webs>
3. calculatePattern
4. update maxKey
5. iterate map by username, put pattern(key) into pattern-map

    private String patternToKey(String web1, String web2, String web3) {
        return web1 + "#" + web2 + "#" + web3;
    }

    private List<String> keyToPattern(String key) {
        return Arrays.asList(key.split("\\#"));
    }

["joe",  "joe",  "joe",  "james","james","james","james","mary","mary", "mary"]
["home","about","career","home","cart",   "maps", "home","home","about","career"]
[  1,     2,       3,      4,     5,        6,     7,     8,      9,       10]


1.  get tuples :  iterate all arrays and
    HashMap: key -> username value: List<List<String>> ["joe","home", 1] ["joe","about", 2]
    use Integer.toString(number) to convert int to string

2.  for each user: sort tuples by timestamp -> new list of web
    use new comparator to sort

3.  find patterns: get all substring of new list of web
    find all substring by timestamp
    X return list<list<string>> -> too complicated
    DO USE ["web1#web2#web3", "web0#web2#web3", "web2#web3#web4"]

4.  compare patter from diff users -> calculate score
    -> update new map: key: pattern, value: score

    string.equals() to compare

5.  return pattern with highest score

*/

import java.util.*;

public class Analyze_User_Website_Visit_Pattern_1152 {

    public class Tuple {
        private String username;
        private String website;
        private int timestamp;

        public Tuple(String username, String website, int timestamp) {
            this.username = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }

    private int maxFrequency = Integer.MIN_VALUE;
    private HashMap<String, List<String>> map = new HashMap<>();
    private HashMap<String, Integer> pattern = new HashMap<>();

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            tuples.add(new Tuple(username[i], website[i], timestamp[i]));
        }
        Collections.sort(tuples, (a, b) -> a.timestamp - b.timestamp);
        initialMap(map, tuples);
        findPatterns(map, pattern);
        System.out.println(map);
        System.out.println(pattern);
        return Arrays.asList(findMostKey(pattern).split("#"));
    }

    private void initialMap(HashMap<String, List<String>> map, List<Tuple> tuples) {
        for (int i = 0; i < tuples.size(); i++) {
            String user = tuples.get(i).username;
            if (!map.containsKey(user)) map.put(user, new ArrayList<>());
            map.get(user).add(tuples.get(i).website);
        }
    }

    private void findPatterns(HashMap<String, List<String>> map, HashMap<String, Integer> pattern) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Set<String> visited = new HashSet<>(); //must inside for loop
            int size = entry.getValue().size();
            List<String> webs = entry.getValue();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String key = webs.get(i) + "#" + webs.get(j) + "#" + webs.get(k);
                        if (!visited.contains(key)) pattern.put(key, pattern.getOrDefault(key, 0) + 1);
                        visited.add(key);
                    }
                }
            }
        }
    }

    private String findMostKey(HashMap<String, Integer> pattern) { //easy to get confused function
        String maxStr = "";
        for (Map.Entry<String, Integer> entry : pattern.entrySet()) {
            String curStr = entry.getKey();
            Integer cur = entry.getValue();
            if (cur > maxFrequency) {
                maxFrequency = cur;
                maxStr = curStr;
            } else if (cur == maxFrequency) {
                if (curStr.compareTo(maxStr) < 0) maxStr = curStr; //compare lexi-> comparing string
            }
        }
        return maxStr;
    }
}
