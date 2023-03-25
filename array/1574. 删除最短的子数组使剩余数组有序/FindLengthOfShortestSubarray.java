class FindLengthOfShortestSubarray {
	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length, r = n - 1;
		while (r > 0 && arr[r - 1] <= arr[r]) r--;
		if (r == 0) return 0;
		int ans = r;
		for (int l = 0; ; r++) {
			while (r == n || arr[l] <= arr[r]) {
				ans = Math.min(ans, r - l - 1);
				if (arr[l] > arr[l + 1]) return ans;
				l++;
			}
		}
	}
}