class SingleNumberCount {
	public int singleNumber(int[] nums) {
		int ret = 0;
        for (int i = 0; i < 32; i++) {  // 每个Integer想成32位的二进制数
            int mask = 1 << i;  // 相当于将第i位置1，其余的全部为0 -> 通过&可以筛选数字
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) cnt++;  // 统计每一位1的个数
            }
            // 如果这一位的数字不可以被3整除，说明这一位数字对那个出现一次的数有贡献，通过｜记录下来
            // 将出现一次的数的每一个有贡献的位记下来，最后的结果就是那个数
            if (cnt % 3 != 0) ret |= mask;
        }
        return ret;
	}

	public static void main(String[] args) {
		SingleNumberCount single = new SingleNumberCount();
		int[] nums = new int[] {0,1,0,1,0,1,99};
		// nums = new int[] {2,2,3,2};
		System.out.println(single.singleNumber(nums));
	}
}