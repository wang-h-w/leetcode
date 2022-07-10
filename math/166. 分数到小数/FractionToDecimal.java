import java.util.Map;
import java.util.HashMap;

class FractionToDecimal {
	public String fractionToDecimal(int num, int denom) {
		long numerator = num, denominator = denom;
		StringBuffer sb = new StringBuffer();
		Map<Long, Integer> map = new HashMap<>();
		int i = 0;

		if (!(numerator >= 0 && denominator > 0)) {
			if (numerator <= 0 && denominator < 0) {
				numerator = -numerator;
				denominator = -denominator;
			} else {
				numerator = Math.abs(numerator);
				denominator = Math.abs(denominator);
				sb.append("-");
			}
		}
		sb.append(numerator / denominator);
		numerator = numerator % denominator;
		if (numerator != 0) sb.append(".");

		while (numerator != 0) {
			map.put(numerator, i++);
			if (numerator < denominator) numerator *= 10;
			sb.append(numerator / denominator);
			numerator = numerator % denominator;
			if (map.containsKey(numerator)) {
				sb.insert(sb.length() - i + map.get(numerator), "(");
				sb.insert(sb.length(), ")");
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		FractionToDecimal f = new FractionToDecimal();
		System.out.println(f.fractionToDecimal(1,2));
		System.out.println(f.fractionToDecimal(2,1));
		System.out.println(f.fractionToDecimal(4,9));
		System.out.println(f.fractionToDecimal(4,333));
		System.out.println(f.fractionToDecimal(1,6));
		System.out.println(f.fractionToDecimal(-50,8));
		System.out.println(f.fractionToDecimal(7,-12));
	}
}