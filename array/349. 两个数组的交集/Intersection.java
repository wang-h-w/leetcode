import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i : nums1) set.add(i);
		for (int i : nums2) {
			if (set.remove(i)) res.add(i);
		}

		Integer[] resArray = res.toArray(new Integer[res.size()]);
		return Arrays.stream(resArray).mapToInt(Integer::valueOf).toArray();
	}

	public static void main(String[] args) {
		Intersection inter = new Intersection();

		int[] res = inter.intersection(new int[] {1,2,2,1}, new int[] {2,2});
		for (int i : res) System.out.print(i + " ");
		System.out.println();

		res = inter.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}