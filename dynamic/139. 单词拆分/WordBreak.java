import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		// 一维数组记录当前位置是否可被拆分
		int n = s.length();
        boolean[] memo = new boolean[n + 1]; // memo[i]表示s中索引为[0,i-1]范围的字符串是否可被wordDict拆分
        memo[0] = true; // 边界条件，默认空字符串可被拆分
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // [0,i]的字符串可被拆分，当且仅当任一子串[0,j]及[j,i]可被拆分
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> wordDict = new ArrayList<>();
		// wordDict.add("apple");
		// wordDict.add("pen");
		// wordDict.add("apple");
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		System.out.println(wb.wordBreak("catsandog", wordDict));
	}
}