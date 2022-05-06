public class Convert {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		String[] strings = new String[numRows];
		int pointer = 0;
		boolean plus = true;
		for (int i = 0; i < numRows; i++) {
			strings[i] = "";
		}

		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			strings[pointer] = strings[pointer].concat(c);
			if (plus) {
				pointer += 1;
				if (pointer > numRows - 1) {
					pointer -= 2;
					plus = false;
				}
			} else {
				pointer -= 1;
				if (pointer < 0) {
					pointer += 2;
					plus = true;
				}
			}
		}

		for (int i = 1; i < numRows; i++) {
			strings[0] = strings[0].concat(strings[i]);
		}
		return strings[0];
	}

	public static void main(String[] args) {
		Convert c = new Convert();
		String s = "PAYPALISHIRING";
		s = "wang,h.w";
		String result = c.convert(s, 3);
		System.out.println(result);
	}
}