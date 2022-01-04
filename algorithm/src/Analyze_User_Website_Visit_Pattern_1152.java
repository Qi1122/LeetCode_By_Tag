/*
https://leetcode.com/problems/analyze-user-website-visit-pattern/

总结：type，记得存什么，String immutable！

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

    private int maxCount = Integer.MIN_VALUE;

    class Tuple {
        String username;
        String website;
        int timestamp;

        public Tuple(String username, String website, int timestamp) {
            this.username = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Tuple> tuples = new ArrayList<>();
        for(int i = 0; i < username.length; i++) {
            tuples.add(new Tuple(username[i], website[i], timestamp[i]));
        }
        Collections.sort(tuples, (a, b) -> a.timestamp - b.timestamp); //

        HashMap<String, List<String>> map = new HashMap<>();
        for (Tuple tuple : tuples) {
            if (!map.containsKey(tuple.username)) map.put(tuple.username, new ArrayList<String>());
            map.get(tuple.username).add(tuple.website);
        }

        HashMap<String, Integer> patternCount = new HashMap<>();
        calculatePatternCount(map, patternCount);
        return keyToPattern(updateMaxKey(patternCount));
    }

    private void calculatePatternCount(HashMap<String, List<String>> map, HashMap<String, Integer> patternCount) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> webList = entry.getValue();
            int size = webList.size();
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < size - 2; i++) { //web1
                for (int j = i + 1; j < size - 1; j++) { //web2
                    for (int k = j + 1; k < size; k++) { //web3
                        String key = patternToKey(webList.get(i), webList.get(j), webList.get(k));
                        if (!visited.contains(key))
                            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
                        visited.add(key);
                    }
                }
            }
        }
    }

    private String updateMaxKey(HashMap<String, Integer> patternCount) {
        String maxKey = "";
        for(Map.Entry<String, Integer> entry : patternCount.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            if (maxCount < val) {
                maxCount = val;
                maxKey = key;
            }
            else if (maxCount == val) {
                if (key.compareTo(maxKey) < 0) maxKey = key;
            }
        }
        return maxKey;
    }

    private String patternToKey(String web1, String web2, String web3) {
        return web1 + "#" + web2 + "#" + web3;
    }

    private List<String> keyToPattern(String key) {
        String[] pattern = key.split("\\#");
        return Arrays.asList(pattern);
    }
}
