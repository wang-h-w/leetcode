class MinElements {
	public int minElements(int[] nums, int limit, int goal) {
		long sum = 0, steps = 0;
		for (int x : nums) sum += x;
		long dist = Math.abs(goal - sum);
		if (dist == 0) return 0;
		steps += dist / limit;
		if (dist % limit != 0 || dist < limit) steps += 1;
		return (int)steps;
	}
}