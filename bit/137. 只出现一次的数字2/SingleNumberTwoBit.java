import java.util.HashSet;

class SingleNumberTwoBit {
	public int singleNumber(int[] nums) {
		int a = 0, b = 0;
		for (int num: nums) {
			a = (a ^ num) & ~b;
			b = (b ^ num) & ~a;
		}
		return a;
	}

	public static void main(String[] args) {
		SingleNumberTwoBit single = new SingleNumberTwoBit();
		int[] nums = new int[] {0,1,0,1,0,1,99};
		nums = new int[] {2,2,3,2};
		System.out.println(single.singleNumber(nums));
	}
}