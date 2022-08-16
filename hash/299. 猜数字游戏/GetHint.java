import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class GetHint {
	public String getHint(String secret, String guess) {
		Map<Character, Integer> map = new HashMap<>();
		Set<Integer> exclude = new HashSet<>();
		int n = secret.length(), bulls = 0, cows = 0;
		for (int i = 0; i < n; i++) {
			char c1 = secret.charAt(i), c2 = guess.charAt(i);
			if (c1 == c2) {
				bulls++;
				exclude.add(i);
			}
			else {
				if (!map.containsKey(c1)) map.put(c1, 1);
				else map.put(c1, map.get(c1) + 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (exclude.contains(i)) continue;
			char c2 = guess.charAt(i);
			if (map.containsKey(c2) && map.get(c2) != 0) {
				cows++;
				map.put(c2, map.get(c2) - 1);
			} 
		}

		StringBuffer sb = new StringBuffer();
		sb.append(bulls);
		sb.append('A');
		sb.append(cows);
		sb.append('B');
		return sb.toString();
	}

	public static void main(String[] args) {
		GetHint hint = new GetHint();
		System.out.println(hint.getHint("1807", "7810"));
		System.out.println(hint.getHint("1123", "0111"));
		System.out.println(hint.getHint("112321", "111212"));
	}
}