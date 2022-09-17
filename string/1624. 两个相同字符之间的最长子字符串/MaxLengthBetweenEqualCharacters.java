import java.util.Arrays;

class MaxLengthBetweenEqualCharacters {
	public int maxLengthBetweenEqualCharacters(String s) {
		int[] memory = new int[26];
		int n = s.length(), max = Integer.MIN_VALUE;
		Arrays.fill(memory, -1);

		// record first
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (memory[c-'a'] == -1) memory[c-'a'] = i;
		}

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			max = Math.max(max, i - memory[c-'a'] - 1);
		}

		return max;
	}

	public static void main(String[] args) {
		MaxLengthBetweenEqualCharacters l = new MaxLengthBetweenEqualCharacters();
		System.out.println(l.maxLengthBetweenEqualCharacters("aa"));
		System.out.println(l.maxLengthBetweenEqualCharacters("a"));
		System.out.println(l.maxLengthBetweenEqualCharacters("abca"));
		System.out.println(l.maxLengthBetweenEqualCharacters("cbzxy"));
		System.out.println(l.maxLengthBetweenEqualCharacters("cabbac"));
	}
}