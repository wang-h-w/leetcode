class SplitArray {
	public int splitArray(int[] nums, int k) {
		// 二分查找的前提：有序且有界
		// 当题目中出现“连续+非负”之类的词语时，可以联想二分查找
		// 这里的二分查找，其实是搜索所有可能的值，找到符合划分数目的最小值
		// 之所以可以这么找，是因为存在规律：划分数目越多，各连续子数组和的最大值越小 -> 单调性
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			max = Math.max(max, i);
		}

		int left = max, right = sum;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int s = split(nums, mid);
			if (s > k) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	private int split(int[] nums, int maxSum) {
		int cnt = 1, temp = 0;
		for (int i : nums) {
			if (temp + i > maxSum) {
				temp = i;
				cnt++;
			} else temp += i;
		}
		return cnt;
	}

	public static void main(String[] args) {
		SplitArray sa = new SplitArray();
		System.out.println(sa.splitArray(new int[] {7,2,5,10,8}, 2));
		System.out.println(sa.splitArray(new int[] {1,2,3,4,5}, 2));
		System.out.println(sa.splitArray(new int[] {1,4,4}, 3));
	}
}