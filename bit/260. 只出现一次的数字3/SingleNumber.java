import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class SingleNumber {
	public int[] singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) set.remove(nums[i]);
			else set.add(nums[i]);
		}
		Integer[] res = set.toArray(new Integer[2]);
		return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
	}

	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		int[] res = s.singleNumber(new int[] {1,2,1,3,2,5});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = s.singleNumber(new int[] {-1, 0});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = s.singleNumber(new int[] {0,1});
		for (int i : res) System.out.print(i + " ");
	}
}