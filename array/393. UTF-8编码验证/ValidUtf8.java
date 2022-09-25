class ValidUtf8 {
	public boolean validUtf8(int[] data) {
		int n = data.length, curr = 0;
		while (curr < n) {
			int first = data[curr], len = 0;
			for (int i = 0; i < 8; i++) {
				int add = (first >> i) & 1;
				if (add == 0) len = 0;
				else len++;
			}
			if (len == 0) curr++;
			else if (len == 1 || len > 4) return false;
			else {
				for (int i = 0; i < len - 1; i++) {
					if (++curr >= n) return false;
					int next = data[curr];
					if (((next >> 7) & 1) != 1 || ((next >> 6) & 1) != 0) return false;
				}
				curr++;
			}
		}
		return true;
	}
}