import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class DisjointSet {
    private int[] parent;
    private int[] size;
	public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        if (len == 0) return 0;
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) parent[i] = i;  // independent

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) continue;
            size[i] -= 1;
            if (map.containsKey(nums[i] - 1)) connect(i, map.get(nums[i] - 1));
            if (map.containsKey(nums[i] + 1)) connect(i, map.get(nums[i] + 1));
            map.put(nums[i], i);
        }

        Arrays.sort(size);
		return -size[0];
	}

    private void connect(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        if (root1 == root2) return;
        parent[root1] = root2;
        size[root2] += size[root1];
    }

    private boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    private int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

	public static void main(String[] args) {
		DisjointSet l = new DisjointSet();
		int[] nums = new int[] {100,4,200,1,3,2};
        nums = new int[] {0,3,7,2,5,8,4,6,0,1};
        nums = new int[] {};
		System.out.println(l.longestConsecutive(nums));
	}
}