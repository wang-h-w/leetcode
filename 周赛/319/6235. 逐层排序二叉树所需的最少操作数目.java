import java.util.*;

class Solution {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int minimumOperations(TreeNode root) {
		int res = 0;
		Deque<TreeNode> d = new LinkedList<>();
		d.offer(root);
		while (!d.isEmpty()) {
			List<Integer> list = new ArrayList();
			int size = d.size();
			while (size-- > 0) {
				TreeNode curr = d.pollFirst();
				if (curr.left != null) {
                    d.offer(curr.left);
                    list.add(curr.left.val);
                }
                if (curr.right != null) {
                    d.offer(curr.right);
				    list.add(curr.right.val);
                }
			}
			res += minSwap(list.stream().mapToInt(Integer::valueOf).toArray());
		}
		return res;
	}

	private int minSwap(int[] nums) {
		int res = 0, n = nums.length;
		int[] copy = Arrays.copyOf(nums, n);
		Arrays.sort(copy);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(copy[i], i);
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			while (map.get(nums[i]) != i) {
				int j = map.get(nums[i]);
				swap(nums, i, j);
				res++;
			}
		}
		return res;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}