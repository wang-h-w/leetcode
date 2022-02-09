import java.util.HashMap;

public class RomanToInt_HashMap {
	/**
	 * 当所需查询的数据过少时，哈希表无法体现出优势，此时速度不如switch语句
	 */
	public int romanToInt(String s) {
		HashMap<Character, Integer> ref = new HashMap<>();
		ref.put('I', 1);
		ref.put('V', 5);
		ref.put('X', 10);
		ref.put('L', 50);
		ref.put('C', 100);
		ref.put('D', 500);
		ref.put('M', 1000);

		int result = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			int curr = ref.get(s.charAt(i));
			int next = ref.get(s.charAt(i+1));
			if (curr < next) {
				result -= curr;
			} else {
				result += curr;
			}
		}
		result += ref.get(s.charAt(s.length() - 1));

		return result;
	}

	public static void main(String[] args) {
		String s = "MCMXCIV";
		RomanToInt_HashMap r = new RomanToInt_HashMap();
		System.out.println(r.romanToInt(s));
	}
}