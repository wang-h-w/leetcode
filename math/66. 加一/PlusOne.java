import java.util.Arrays;

class PlusOne {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] < 10) break;
			digits[i] = 0;
		}
		if (digits[0] == 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			digits = newDigits;
		}

		return digits;
	}

	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = new int[] {4,3,2,1};
		digits = new int[] {9,9,9,9};
		int[] result = po.plusOne(digits);
		for (int i: result) System.out.print(i + " ");
	}
}