/*
https://leetcode.com/problems/insert-delete-getrandom-o1/

DS: ArrayList, HashMap

Time Complexity: each function has average O(1)

Space Complexity: O(N) N -> number of values currently stored in DS

definition:

List<Integer> : all inserted numbers
Map<Integer, Integer>:  key: inserted number
                        value: the index of "key" in the list

why need a map? search list: O(n), search map: O(1)
list feature：add() -> add from tail
           remove(index) -> remove at index

Algo:
1. insert item in list
2. put item in map with index
3. remove: -> swap remove item with tail -> update tail index in map -> remove from map & list
4. use random.nextInt() = any index of list
*/
package algorithm.src;
import java.util.*;

public class Insert_Remove_GetRandom_380 {
    private List<Integer> list;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public Insert_Remove_GetRandom_380() {
        this.list = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return false;
        indexMap.put(val, list.size()); //list.size() = index of insert value
        list.add(val);
        return true;
    }
    //update index in the list
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;
        int index = indexMap.get(val); //get index of remove item
        int tailIndex = list.size() - 1; //
        if (index != tailIndex) { //if remove item is not last item in list -> need to update
            int tailItem  = list.get(tailIndex);
            list.set(index, tailItem ); //swap tail with remove item
            indexMap.put(tailItem , index); //update tail value with new index
        }
        list.remove(tailIndex); //always remove the tail item, so all index in map don't need to change
        indexMap.remove(val); //tail and remove item have same index now
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
