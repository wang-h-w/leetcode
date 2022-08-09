class FindDuplicate {
	public int findDuplicate(int[] nums) {
		int fast = 0, slow = 0;
		while (true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if (fast == slow) break;
		}
		int finder = 0;
		while (true) {
			finder = nums[finder];
			slow = nums[slow];
			if (slow == finder) break;
		}
		return slow;
	}

	public static void main(String[] args) {
		FindDuplicate f = new FindDuplicate();
		System.out.println(f.findDuplicate(new int[] {1,3,4,2,2}));
		System.out.println(f.findDuplicate(new int[] {3,1,3,4,2}));
	}
}