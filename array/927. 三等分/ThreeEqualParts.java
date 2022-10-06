class ThreeEqualParts {
	public int[] threeEqualParts(int[] arr) {
		int[] res = new int[] {-1, -1};
		int[] compare = new int[3];
		int[] tempRes = new int[3];
		// count 1
		int cntOne = 0;
		for (int i : arr) if (i == 1) cntOne++;
		if (cntOne % 3 != 0) return res;
		if (cntOne == 0) return new int[] {0, arr.length - 1};
		// count last 0
		int cntLastZero = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 1) break;
			cntLastZero++;
		}
		// calculate three number
		int cnt = cntOne / 3, num = 0, numIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] == 1) cnt--;
			num = num * 2 + arr[i];

			if (cnt == 0) {
				cnt = cntOne / 3;
				int cntZero = cntLastZero;
				while (cntZero-- > 0) {
					if (++i < arr.length && arr[i] != 0) return res;
					num *= 2;
				}
				compare[numIdx] = num;
				tempRes[numIdx++] = i;
				num = 0;
			}
		}
		// return
		if (compare[0] != compare[1] || compare[1] != compare[2]) return res;
		res[0] = tempRes[0];
		res[1] = tempRes[1] + 1;
		return res;
	}

	public static void main(String[] args) {
		ThreeEqualParts equal = new ThreeEqualParts();
		int[] res = equal.threeEqualParts(new int[] {1,0,1,0,1});
		for (int i = 0; i < 2; i++) System.out.print(res[i] + " ");
		System.out.println();
		res = equal.threeEqualParts(new int[] {1,1,0,1,1});
		for (int i = 0; i < 2; i++) System.out.print(res[i] + " ");
		System.out.println();
		res = equal.threeEqualParts(new int[] {1,1,0,0,1});
		for (int i = 0; i < 2; i++) System.out.print(res[i] + " ");
		System.out.println();
		res = equal.threeEqualParts(new int[] {1,0,1,1});
		for (int i = 0; i < 2; i++) System.out.print(res[i] + " ");
		System.out.println();
	}
}