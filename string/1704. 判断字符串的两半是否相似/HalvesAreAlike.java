import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class HalvesAreAlike {
	public boolean halvesAreAlike(String s) {
		int n = s.length();
		if (n % 2 != 0) return false;
		Character[] dict = new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		Set<Character> set = new HashSet<Character>(Arrays.asList(dict));
		int a = 0, b = n / 2, cnt1 = 0, cnt2 = 0;
		while (b < n) {
			char c1 = s.charAt(a++), c2 = s.charAt(b++);
			if (set.contains(c1)) cnt1++;
			if (set.contains(c2)) cnt2++;
		}
		return cnt1 == cnt2;
	}

	public static void main(String[] args) {
		HalvesAreAlike h = new HalvesAreAlike();
		System.out.println(h.halvesAreAlike("book"));
		System.out.println(h.halvesAreAlike("textbook"));
	}
}