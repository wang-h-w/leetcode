import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class ReverseWords {
	public String reverseWords(String s) {
		// 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
	}

	public static void main(String[] args) {
		ReverseWords r = new ReverseWords();
		System.out.println(r.reverseWords("a good   example"));
		System.out.println(r.reverseWords("  hello world  "));
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("      "));
	}
}