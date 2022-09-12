import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

class RandomizedSet {
    private Map<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        list.remove(list.size() - 1);
        map.put(last, idx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}