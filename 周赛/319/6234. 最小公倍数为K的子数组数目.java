class Solution {
	public int subarrayLCM(int[] nums, int k) {
		int res = 0, left = 0, right = left;
		while (left < nums.length) {
			right = left;
			int prev = nums[right];
			while (right < nums.length) {
				int temp = lcm(nums[right++], prev);
				if (temp > k) break;
				if (temp == k) res++;
				prev = temp;
			}
			left++;
		}
		return res;
	}

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.subarrayLCM(new int[] {3,6,2,7,1}, 6));
		System.out.println(s.subarrayLCM(new int[] {3}, 2));
	}
}