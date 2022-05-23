class SearchRecursive {
	public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		SearchRecursive s = new SearchRecursive();
		int[] nums = new int[] {4,5,6,7,0,1,2};
		int result = s.search(nums, 7);
		System.out.println(result);
	}
}