class MaxProduct {
	public int maxProduct(int[] nums) {
		int pos = nums[0], neg = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 关键是找出mul1 mul2 nums[i]中最大的和最小的
			int mul1 = pos * nums[i];
			int mul2 = neg * nums[i];
			// 找最大
			if (mul1 > mul2) {
				if (mul1 > nums[i]) pos = mul1;
				else pos = nums[i];
			} else {
				if (mul2 > nums[i]) pos = mul2;
				else pos = nums[i];
			}
			// 找最小
			if (mul1 < mul2) {
				if (mul1 < nums[i]) neg = mul1;
				else neg = nums[i];
			} else {
				if (mul2 < nums[i]) neg = mul2;
				else neg = nums[i];
			}
			max = max > pos ? max : pos;
		}
		/*
			简介版本（nums[i]如果为负数则当前最大和最小交换
			public int maxProduct(int[] nums) {
		        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		        for(int i=0; i<nums.length; i++){
		            if(nums[i] < 0){ 
		              int tmp = imax;
		              imax = imin;
		              imin = tmp;
		            }
		            imax = Math.max(imax*nums[i], nums[i]);
		            imin = Math.min(imin*nums[i], nums[i]);
		            
		            max = Math.max(max, imax);
		        }
		        return max;
    		}
		*/
		return max;
	}

	public static void main(String[] args) {
		MaxProduct m = new MaxProduct();
		int[] nums = new int[] {2,3,-2,4};
		System.out.println(m.maxProduct(nums));
		nums = new int[] {-2,0,-1};
		System.out.println(m.maxProduct(nums));
		nums = new int[] {-2,3,-4};
		System.out.println(m.maxProduct(nums));
		nums = new int[] {2,-5,-2,-4,3};
		System.out.println(m.maxProduct(nums));
	}
}