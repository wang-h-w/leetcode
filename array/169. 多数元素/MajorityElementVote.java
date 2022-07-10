import java.util.Arrays;

class MajorityElement {
	public int majorityElement(int[] nums) {
		int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
	}

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int[] nums = new int[] {2,2,1,1,1,2,2};
		System.out.println(m.majorityElement(nums));
	}
}