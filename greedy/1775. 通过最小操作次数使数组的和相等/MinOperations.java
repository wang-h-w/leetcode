import java.util.PriorityQueue;

class MinOperations {
	public int minOperations(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length, sum1 = 0, sum2 = 0;
		for (int x : nums1) sum1 += x;
		for (int x : nums2) sum2 += x;
		if (sum1 == sum2) return 0;
		if (sum1 < sum2) return minOperations(nums2, nums1);
		// 现在sum1一定大于sum2
		int diff = sum1 - sum2, res = 0, currMax = 5;
		int[] memo = new int[6];
		for (int x : nums1) memo[x - 1]++;
		for (int x : nums2) memo[6 - x]++;
		while (diff > 0 && currMax >= 1) {
			while (diff > 0 && memo[currMax] > 0) {
				res+= 1;
				if (currMax >= diff) {
					diff = 0;
					break;
				} else {
					diff -= currMax;
					memo[currMax]--;
				}
			}
			currMax--;
		}
		return diff == 0 ? res : -1;
	}

	public static void main(String[] args) {
		MinOperations mo = new MinOperations();
		System.out.println(mo.minOperations(new int[] {1,2,3,4,5,6}, new int[] {1,1,2,2,2,2}));
		System.out.println(mo.minOperations(new int[] {1,1,1,1,1,1,1}, new int[] {6}));
		System.out.println(mo.minOperations(new int[] {6,6}, new int[] {1}));
	}
}