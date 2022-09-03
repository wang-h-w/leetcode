import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 > n2) return intersect(nums2, nums1);
		List<Integer> list = new ArrayList<>();
		int p1 = 0, p2 = 0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		while (p1 < n1 && p2 < n2) {
			if (nums1[p1] < nums2[p2]) p1++;
			else if (nums1[p1] > nums2[p2]) p2++;
			else {
				list.add(nums1[p1]);
				p1++;
				p2++;
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
		return res;
	}

	public static void main(String[] args) {
		Intersect inter = new Intersect();

		int[] res = inter.intersect(new int[] {1,2,2,1}, new int[] {2,2});
		for (int i : res) System.out.print(i + " ");
		System.out.println();

		res = inter.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}