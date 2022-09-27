import java.util.Arrays;

class Solution {
	public boolean CheckPermutation(String s1, String s2) {
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.toString(c1).equals(Arrays.toString(c2));
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.CheckPermutation("abc", "bca"));
		System.out.println(s.CheckPermutation("abc", "bad"));
	}
}