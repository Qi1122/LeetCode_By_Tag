/*
https://leetcode.com/problems/analyze-user-website-visit-pattern/

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
}
