import java.util.Arrays;

class SpecialArray {
	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		int res = nums.length, prev = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= res && prev < res) return res;
			res--;
			prev = nums[i];
		}
		return --res;
	}

	public static void main(String[] args) {
		SpecialArray sa = new SpecialArray();
		System.out.println(sa.specialArray(new int[] {3,5}));
		System.out.println(sa.specialArray(new int[] {0,0}));
		System.out.println(sa.specialArray(new int[] {0,4,3,0,4}));
		System.out.println(sa.specialArray(new int[] {3,6,7,7,0}));
	}
}