import java.util.Arrays;

class WiggleSort {
	public void wiggleSort(int[] nums) {
		int[] count = new int[5001];
		int idx = 5000;
		for (int i : nums) count[i]++;
		for (int i = 1; i < nums.length; i += 2) {
			while (count[idx] == 0) idx--;
			count[idx]--;
			nums[i] = idx;
		}
		for (int i = 0; i < nums.length; i += 2) {
			while (count[idx] == 0) idx--;
			count[idx]--;
			nums[i] = idx;
		}
	}

	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int[] nums = new int[] {1,5,1,1,6,4};
		ws.wiggleSort(nums);
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {1,3,2,2,3,1};
		ws.wiggleSort(nums);
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
	}
}