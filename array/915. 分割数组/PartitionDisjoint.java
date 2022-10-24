class PartitionDisjoint {
	public int partitionDisjoint(int[] nums) {
		int n = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int[] maxArray = new int[n], minArray = new int[n];
		for (int i = 0, j = n - 1; i < n; i++, j--) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[j]);
			maxArray[i] = max;
			minArray[j] = min;
		}
		for (int i = 0; i < n - 1; i++) {
			if (maxArray[i] <= minArray[i + 1]) return i + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		PartitionDisjoint pd = new PartitionDisjoint();
		System.out.println(pd.partitionDisjoint(new int[] {5,0,3,8,6}));
		System.out.println(pd.partitionDisjoint(new int[] {1,1,1,0,6,12}));
	}
}