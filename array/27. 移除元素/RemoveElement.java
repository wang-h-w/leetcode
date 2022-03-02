class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int ptr = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[ptr] = nums[i];
				ptr++;
			}
		}
		return ptr;
    }

    public static void main(String[] args) {
    	RemoveElement r = new RemoveElement();
    	int[] nums = new int[] {0, 4, -1, 2};
    	int result = r.removeElement(nums, 2);
    	System.out.println("num: " + result);
    	for (int i = 0; i < result; i++) {
    		System.out.println(nums[i]);
    	}
    }
}