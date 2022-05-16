import java.util.List;
import java.util.LinkedList;

class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		List<String> ret = new LinkedList<>();
		if (digits.length() == 0) {
			return ret;
		}
		String[][] nums = new String[digits.length()][];
		for (int i = 0; i < digits.length(); i++) {
			nums[i] = digitToChar(digits.charAt(i));
		}
		backtrack(nums, "", ret, 0);
		return ret;
	}

	private void backtrack(String[][] nums, String track, List<String> ret, int place) {
		if (place == nums.length) {
			ret.add(track);
			return;
		}
		for (int i = 0; i < nums[place].length; i++) {
			track += nums[place][i];
			backtrack(nums, track, ret, place + 1);
			track = track.substring(0, track.length() - 1);
		}
	}

	private String[] digitToChar(char digit) {
		switch (digit) {
			case '2': return new String[] {"a", "b", "c"};
			case '3': return new String[] {"d", "e", "f"};
			case '4': return new String[] {"g", "h", "i"};
			case '5': return new String[] {"j", "k", "l"};
			case '6': return new String[] {"m", "n", "o"};
			case '7': return new String[] {"p", "q", "r", "s"};
			case '8': return new String[] {"t", "u", "v"};
			case '9': return new String[] {"w", "x", "y", "z"};
		}
		return null;
	}

	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
		String s = "";
		s = "872";
		List<String> result = lc.letterCombinations(s);
		System.out.println(result);
	}
}