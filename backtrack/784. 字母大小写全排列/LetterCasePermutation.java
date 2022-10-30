import java.util.List;
import java.util.LinkedList;

class LetterCasePermutation {
	private List<String> ret;
	private StringBuffer sb;
	private static final int d = 'A' - 'a';

	public List<String> letterCasePermutation(String s) {
		ret = new LinkedList<>();
		sb = new StringBuffer();
		backtrack(s, 0);
		return ret;
	}

	private void backtrack(String s, int index) {
		if (index == s.length()) {
			ret.add(sb.toString());
			return;
		}
		char c = s.charAt(index);
		if ('0' <= c && c <= '9') {
			sb.append(c);
			backtrack(s, index + 1);
			sb.deleteCharAt(index);
		} else {
			// 大小写转换也可以写成【异或一个空格】
			sb.append(c);
			backtrack(s, index + 1);
			sb.deleteCharAt(index);
			// 大小写转换也可以写成【异或一个空格】
			sb.append((char)(c ^ ' '));
			// if (c > 'Z') sb.append((char)(c + d));
			// else sb.append((char)(c - d));
			backtrack(s, index + 1);
			sb.deleteCharAt(index);
		}
	}

	public static void main(String[] args) {
		LetterCasePermutation p = new LetterCasePermutation();
		System.out.println(p.letterCasePermutation("a1b2"));
		System.out.println(p.letterCasePermutation("3z4"));
		System.out.println(p.letterCasePermutation("a1B2"));
	}
}