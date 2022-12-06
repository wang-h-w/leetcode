import java.util.Set;
import java.util.HashSet;

class NumDifferentIntegers {
	public int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		int n = word.length();
		for (int i = 0; i < n; i++) {
			if (!Character.isDigit(word.charAt(i))) continue;
			while (i < n && word.charAt(i) == '0') i++;
			int j = i;
			while (j < n && Character.isDigit(word.charAt(j))) j++;
			set.add(word.substring(i, j));
			i = j;
		}
		return set.size();
	}

	public static void main(String[] args) {
		NumDifferentIntegers nd = new NumDifferentIntegers();
		System.out.println(nd.numDifferentIntegers("a123bc34d8ef34"));
		System.out.println(nd.numDifferentIntegers("leet1234code234"));
		System.out.println(nd.numDifferentIntegers("a1b01c001"));
		System.out.println(nd.numDifferentIntegers("a0b1b01c001"));
	}
}