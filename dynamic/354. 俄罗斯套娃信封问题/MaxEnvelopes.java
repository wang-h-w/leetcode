class MaxEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length, res = 1;
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] == b[0]) return b[1] - a[1];
			return a[0] - b[0];
		});
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) dp[i] = envelopes[i][1];
		return lengthOfLIS(dp);
	}

	private int lengthOfLIS(int[] nums) {
	    int[] top = new int[nums.length];
	    // 牌堆数初始化为 0
	    int piles = 0;
	    for (int i = 0; i < nums.length; i++) {
	        // 要处理的扑克牌
	        int poker = nums[i];

	        /***** 搜索左侧边界的二分查找 *****/
	        int left = 0, right = piles;
	        while (left < right) {
	            int mid = (left + right) / 2;
	            if (top[mid] > poker) {
	                right = mid;
	            } else if (top[mid] < poker) {
	                left = mid + 1;
	            } else {
	                right = mid;
	            }
	        }
	        /*********************************/
	        
	        // 没找到合适的牌堆，新建一堆
	        if (left == piles) piles++;
	        // 把这张牌放到牌堆顶
	        top[left] = poker;
	    }
	    // 牌堆数就是 LIS 长度
	    return piles;
	}
}