class FindLongestSubarray {
	public String[] findLongestSubarray(String[] array) {
		int n = array.length, left = 0, len = Integer.MIN_VALUE;
		int[] preSum = new int[n + 1];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		for (int i = 1; i <= n; i++) {
			char c = array[i - 1].charAt(0);
			preSum[i] = preSum[i - 1] + (c >= '0' && c <= '9' ? -1 : 1);
			if (map.containsKey(preSum[i])) {
				int temp = i - map.get(preSum[i]);
				if (temp > len) {
					len = temp;
					left = map.get(preSum[i]);
				}
			} else {
				map.put(preSum[i], i);
			}

		}
		if (len == Integer.MIN_VALUE) return new String[0];
		String[] res = new String[len];
		for (int i = 0; i < len; i++, left++) res[i] = array[left];
		return res;
	}
}