class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] > nums[i]) {
                nums[idx] = nums[i+1];
                idx += 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1, 2, 4, 4, 6, 6};
        RemoveDuplicates r = new RemoveDuplicates();
        int len = r.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}