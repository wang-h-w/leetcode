import java.util.Stack;

class DecodeString {
	public String decodeString(String s) {
		char[] charArray = s.toCharArray();
		int n = charArray.length, mul = 0;
		StringBuffer sb = new StringBuffer();
		Stack<Integer> mulStack = new Stack<>();
		Stack<StringBuffer> stringStack = new Stack<>();
		for (int i = 0; i < n; i++) {
			char c = charArray[i];
			if ('0' <= c && c <= '9') {
				mul = mul * 10 + c - '0';
			} else if (c == '[') {
				mulStack.push(mul);
				mul = 0;
				stringStack.push(sb);
				sb = new StringBuffer();
			} else if (c == ']') {
				int times = mulStack.pop();
				StringBuffer temp = stringStack.pop();
				while (times-- != 0) temp.append(sb.toString());
				sb = temp;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a]2[bc]"));
		System.out.println(ds.decodeString("3[a2[c]]"));
		System.out.println(ds.decodeString("2[abc]3[cd]ef"));
		System.out.println(ds.decodeString("abc3[cd]xyz"));
	}
}