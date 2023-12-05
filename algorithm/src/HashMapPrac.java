package algorithm.src;

//import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;

public class HashMapPrac {
    public void prac(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.computeIfAbsent(num, key -> 0);
            map.put(num, map.get(num) + 1);
        }
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void main(String[] args) {
        HashMapPrac sol = new HashMapPrac();
        List<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(5);
            add(1);
            add(2);
            add(3);
            add(5);
            add(7);
        }};
        sol.prac(list);
    }
}
