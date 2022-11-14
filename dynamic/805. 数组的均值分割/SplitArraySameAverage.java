import java.util.*;

class SplitArraySameAverage {
	public boolean splitArraySameAverage(int[] nums) {
		int n = nums.length, m = n / 2, sum = 0; // 需要折半进行优化
		for (int x : nums) sum += x;
		Map<Integer, Set<Integer>> map = new HashMap<>(); // 总和 -> 个数
		// 先对前半部分的“总和->个数”配对结果进行缓存
		// 假设前半部分有m个数，则用一个长度为m的二进制数表示选择情况
		// 例如1001表示选择第一个数和第四个数
		// 则0-2^m则可包含所有情况
		for (int s = 0; s < (1 << m); s++) { // 在前n/2个数中选择，s表示某一种选择情况
			int tot = 0, cnt = 0;
			for (int i = 0; i < m; i++) {
				if (((s >> i) & 1) == 1) {
					tot += nums[i];
					cnt++;
				}
			}
			Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
			set.add(cnt);
			map.put(tot, set);
		}
		// 通过后半部分，计算满足要求时前半部分应该为多少，如果查询的到，则说明找到划分方法
		for (int s = 0; s < (1 << (n - m)); s++) {
            int tot = 0, cnt = 0;
            for (int i = 0; i < (n - m); i++) {
                if (((s >> i) & 1) == 1) {
                    tot += nums[i + m];
                    cnt++;
                }
            }
            for (int k = Math.max(1, cnt); k < n; k++) {
                if (k * sum % n != 0) continue;
                int t = k * sum / n;
                if (!map.containsKey(t - tot)) continue;
                if (!map.get(t - tot).contains(k - cnt)) continue;
                return true;
            }
        }
        return false;
	}

	public static void main(String[] args) {
		SplitArraySameAverage sa = new SplitArraySameAverage();
		System.out.println(sa.splitArraySameAverage(new int[] {1,2,3,4,5,6,7,8}));
		System.out.println(sa.splitArraySameAverage(new int[] {3,1}));
		System.out.println(sa.splitArraySameAverage(new int[] {0,0,0}));
	}
}