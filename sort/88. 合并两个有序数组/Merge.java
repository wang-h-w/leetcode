class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int curr = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) nums1[curr--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		while (n >=0) nums1[curr--] = nums2[n--];
	}

	public static void main(String[] args) {
		Merge me = new Merge();
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		nums1 = new int[] {0};
		nums2 = new int[] {1};
		me.merge(nums1, 0, nums2, 1);
		for (int i: nums1) System.out.print(i + " ");
	}
}