import java.util.Random;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class AdvantageCount {
	private final static Random random = new Random();
	private Map<Integer, LinkedList<Integer>> map;

	public int[] advantageCount(int[] nums1, int[] nums2) {
		int n = nums1.length;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums2[i])) map.put(nums2[i], new LinkedList<>());
			map.get(nums2[i]).add(i);
		}
		quickSort(nums1, 0, n - 1);
		quickSort(nums2, 0, n - 1);

		int p = 0, q = 0, qr = n - 1;
		int[] res = new int[n];
		while (p < n) {
			if (nums1[p] <= nums2[q]) res[map.get(nums2[qr--]).poll()] = nums1[p++];
			else res[map.get(nums2[q++]).poll()] = nums1[p++];
		}

		return res;
	}

	private void quickSort(int[] nums, int start, int end) {
		if (start >= end) return;
		int index = partition(nums, start, end);
		quickSort(nums, start, index - 1);
		quickSort(nums, index + 1, end);
	}

	private int partition(int[] nums, int start, int end) {
		int pivotIndex = random.nextInt(end - start + 1) + start, pivot = nums[pivotIndex];
		swap(nums, pivotIndex, start);
		int left = start + 1, right = end;
		while (left < right) {
			while (left < right && nums[left] <= pivot) left++;
			while (left < right && nums[right] >= pivot) right--;
			swap(nums, left, right);
		}
		if (left == right && pivot < nums[right]) right--;
		swap(nums, start, right);
		return right;
	}

	private void swap(int[] nums, int p, int q) {
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
	}

	public static void main(String[] args) {
		AdvantageCount ac = new AdvantageCount();
		int[] res = ac.advantageCount(new int[] {2,7,11,15}, new int[] {1,10,4,11});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = ac.advantageCount(new int[] {12,24,8,32}, new int[] {13,25,32,11});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = ac.advantageCount(new int[] {12,24,8,12,32}, new int[] {13,10,25,32,11});
		for (int i : res) System.out.print(i + " ");
	}
}
