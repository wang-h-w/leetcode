import java.util.Arrays;

class MajorityElement {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int[] nums = new int[] {2,2,1,1,1,2,2};
		System.out.println(m.majorityElement(nums));
	}
}