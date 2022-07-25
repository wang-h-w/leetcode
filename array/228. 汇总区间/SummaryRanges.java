import java.util.List;
import java.util.LinkedList;

class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			if (!(i < nums.length - 1 && nums[i] == nums[i+1] - 1)) {
				if (sb.length() > 0) sb.append("->");
				sb.append(nums[i]);
				ret.add(sb.toString());
				sb = new StringBuffer();
			} else {
				if (sb.length() == 0) sb.append(nums[i]);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		System.out.println(sr.summaryRanges(new int[] {0,1,2,4,5,7}));
		System.out.println(sr.summaryRanges(new int[] {0,2,3,4,6,8,9}));
	}
}