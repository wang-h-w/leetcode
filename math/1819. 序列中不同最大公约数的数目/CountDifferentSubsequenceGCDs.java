class CountDifferentSubsequenceGCDs {
	public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occurred = new boolean[maxVal + 1];
        for (int num : nums) {
            occurred[num] = true;
        }
        int count = 0;
        for (int i = 1; i <= maxVal; i++) {
            int divisor = 0;
            for (int j = i; j <= maxVal && divisor != i; j += i) {
                if (occurred[j]) {
                    divisor = gcd(divisor, j);
                }
            }
            if (divisor == i) {
                count++;
            }
        }
        return count;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}