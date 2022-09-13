import java.util.Arrays;

class MaximumSwap {
	public int maximumSwap(int num) {
		if (num == 0) return num;
		char[] numArrayOrigin = String.valueOf(num).toCharArray();
		char[] numArraySort = String.valueOf(num).toCharArray();
		int n = numArraySort.length;
		Arrays.sort(numArraySort);
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			char temp = numArraySort[i];
			numArraySort[i] = numArraySort[j];
			numArraySort[j] = temp;
		}

		int ptr = 0;
		while (ptr < n && numArraySort[ptr] == numArrayOrigin[ptr]) ptr++;
		if (ptr == n) return num;
		char high = numArraySort[ptr], low = numArrayOrigin[ptr];
		numArrayOrigin[ptr] = high;
		for (int i = n - 1; i >= ptr; i--) {
			if (numArrayOrigin[i] == high) {
				numArrayOrigin[i] = low;
				break;
			}
		}

		return Integer.parseInt(new String(numArrayOrigin));
	}

	public static void main(String[] args) {
		MaximumSwap swap = new MaximumSwap();
		System.out.println(swap.maximumSwap(2736));
		System.out.println(swap.maximumSwap(977993));
	}
}