import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class KSmallestPairs {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
			@Override
			public int compare(int[] a, int[] b) {
				return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
			}
		});
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < Math.min(k, nums1.length); i++) pq.offer(new int[] {i, 0});

		while (k-- > 0 && !pq.isEmpty()) {
			int[] smallIdx = pq.poll();
			ret.add(Arrays.asList(nums1[smallIdx[0]], nums2[smallIdx[1]]));
			if (++smallIdx[1] < nums2.length) pq.offer(smallIdx);
		}

		return ret;
	}

	public static void main(String[] args) {
		KSmallestPairs k = new KSmallestPairs();
		System.out.println(k.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3));
		System.out.println(k.kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 2));
		System.out.println(k.kSmallestPairs(new int[] {1,2}, new int[] {3}, 3));
	}
}