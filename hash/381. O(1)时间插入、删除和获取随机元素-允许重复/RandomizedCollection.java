import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

class RandomizedCollection {
    Map<Integer, PriorityQueue<Integer>> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        list.add(val);
        if (map.containsKey(val)) {
            map.get(val).offer(list.size() - 1);
            return false;
        } else {
            map.put(val, new PriorityQueue<>((o1, o2) -> o2 - o1));
            map.get(val).offer(list.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val).peek();
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        list.remove(list.size() - 1);
        map.get(last).poll();
        map.get(last).offer(idx);
        map.get(val).poll();
        if (map.get(val).size() == 0) map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}