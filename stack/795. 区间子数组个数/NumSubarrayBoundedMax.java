import java.util.Deque;
import java.util.LinkedList;

class NumSubarrayBoundedMax {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		// 两个方向都走一遍单调栈，保存的是index
		int n = nums.length;
		int[] ngeLeftToRight = new int[n], ngeRightToLeft = new int[n];
		Deque<Integer> stack = new LinkedList<>();

		// NGE from left to right
		for (int i = 0; i <= n; i++) {
			if (i == n) {
				while (!stack.isEmpty()) ngeLeftToRight[stack.pop()] = n;
				break;
			}
			while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) ngeLeftToRight[stack.pop()] = i;
			stack.push(i);
		}

		// NGE from right to left
		for (int i = n - 1; i >= -1; i--) {
			if (i == -1) {
				while (!stack.isEmpty()) ngeRightToLeft[stack.pop()] = -1;
				break;
			}
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) ngeRightToLeft[stack.pop()] = i;
			stack.push(i);
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > right || nums[i] < left) continue;
			res += Math.abs(ngeLeftToRight[i] - i) * Math.abs(ngeRightToLeft[i] - i);
		}
		return res;
	}

	public static void main(String[] args) {
		NumSubarrayBoundedMax nsbm = new NumSubarrayBoundedMax();
		System.out.println(nsbm.numSubarrayBoundedMax(new int[] {2,1,4,3}, 2, 3));
		System.out.println(nsbm.numSubarrayBoundedMax(new int[] {2,9,2,5,6}, 2, 8));
	}
}