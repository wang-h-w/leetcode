import java.util.HashMap;

class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums){
            if (!map.containsKey(num)){
                int left = map.get(num-1) == null ? 0 : map.get(num-1);
                int right = map.get(num+1) == null ? 0 : map.get(num+1);
                int cur = 1 + left + right;
                res = Math.max(res, cur);
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
	}

	public static void main(String[] args) {
		LongestConsecutive l = new LongestConsecutive();
		int[] nums = new int[] {100,4,200,1,3,2};
		System.out.println(l.longestConsecutive(nums));
	}
}