class ClosestCost {
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		boolean[] dp = new boolean[target + 1]; // 0-1 bag
		int res = Integer.MAX_VALUE;
		for (int x : baseCosts) {
			if (x > target) res = Math.min(res, x);
			else dp[x] = true;
		}
		for (int x : toppingCosts) {
			for (int i = 0; i < 2; i++) { // 选两次
				for (int j = target; j >= 0; j--) {
					if (dp[j] && j + x > target) res = Math.min(res, j + x);
					if (j > x) dp[j] |= dp[j - x];
				}
			}
		}
		for (int i = 0; i <= res - target && i <= target; i++) {
			if (dp[target - i]) return target - i;
		}
		return res;
	}
}