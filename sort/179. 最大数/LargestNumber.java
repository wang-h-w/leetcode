import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
	class NumberComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return (s2+s1).compareTo(s1+s2);
		}
	}

	public String largestNumber(int[] nums) {
		String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
		Comparator<String> cmp = new NumberComparator();
		Arrays.sort(s, cmp);
		StringBuffer sb = new StringBuffer();
		for (String ss: s) sb.append(ss);
		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] nums = new int[] {3,5,34,30,9};
		System.out.println(ln.largestNumber(nums));
	}
}