import java.util.List;
import java.util.ArrayList;

public class Convert_StringBuilder {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}

		int flag = 1;
		int p = 0;

		for (int i = 0; i < s.length(); i++) {
			String str = String.valueOf(s.charAt(i));
			rows.get(p).append(str);
			flag = p + flag > numRows - 1 || p + flag < 0 ? -flag : flag;
			p += flag;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			result.append(rows.get(i));
		}

		return result.toString();
	}
 
	public static void main(String[] args) {
		Convert_StringBuilder c = new Convert_StringBuilder();
		String s = "PAYPALISHIRING";
		// s = "wang,h.w";
		// s = "A";
		String result = c.convert(s, 1);
		System.out.println(result);
	}
}
