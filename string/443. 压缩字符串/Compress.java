class Compress {
	public int compress(char[] chars) {
		char curr = chars[0];
		int arr = 0, cnt = 1, walk = 1, res = 0;;
		while (walk <= chars.length) {
			if (walk < chars.length && chars[walk] == curr) {
				cnt++;
				walk++;
				continue;
			}
			chars[arr++] = curr;
			res++; // character
			if (cnt != 1) {
				Deque<Character> d = new LinkedList<>();
				while (cnt != 0) {
					d.push((char)('0' + cnt % 10));
					cnt /= 10;
					res++; // number
				}
				while (!d.isEmpty()) chars[arr++] = d.pop();
			}
			if (walk < chars.length) {
				curr = chars[walk];
				cnt = 1;
			}
			walk++;
		}
		return res;
	}
}