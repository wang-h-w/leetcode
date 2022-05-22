import java.util.Arrays;
import java.util.ArrayList;

class NextPermutation {
	public void nextPermutation(int[] nums) {
		int size = nums.length;
		int max = Integer.MAX_VALUE;
		int p = -1;

		for (int i = size - 2; i >= 0; i--) {
			if (nums[i] >= nums[size - 1]) {
				max = nums[i];
				p = i;
				while (p < size - 1) {
					nums[p] = nums[p + 1];
					p++;
				}
				nums[size - 1] = max;
				continue;
			} else {
				p = i + 1;
				while (nums[i] >= nums[p] && p < size - 1) p++;
				int temp = nums[i];
				nums[i] = nums[p];
				nums[p] = temp;
				break;
			}
		}
	}

	public static void main(String[] args) {
		NextPermutation p = new NextPermutation();
		int[] x = new int[] {1,2,1,3,11,11,3,2,2};
		p.nextPermutation(x);
		for (int i: x) System.out.println(i);
	}
}