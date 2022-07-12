import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class FindRepeatedDnaSequences {
	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> set = new HashSet<>(), res = new HashSet<>();
		char[] ch = s.toCharArray();
		for (int i = 0; i <= ch.length - 10; i++) {
			String ss = String.valueOf(ch, i, 10);
			if (!set.add(ss)) res.add(ss);
		}

		return new LinkedList<String>(res);
	}

	public static void main(String[] args) {
		FindRepeatedDnaSequences find = new FindRepeatedDnaSequences();
		System.out.println(find.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(find.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}
}