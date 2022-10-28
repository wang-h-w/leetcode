class SumSubarrayMins {
	public int sumSubarrayMins(int[] arr) {
		int n = arr.length, max = arr[0], min = arr[0], minIdx = 0;
		long res = arr[0], sum = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] >= max) {
				sum = sum + arr[i];
				max = arr[i];
			} else if (arr[i] <= min) {
				sum = arr[i] * (i + 1);
				min = arr[i];
				minIdx = i;
			} else {
				sum = arr[i];
				long temp = arr[i];
				for (int j = i - 1; j > minIdx; j--) {
					temp = Math.min(arr[j], temp);
					sum += temp;
				}
				sum += min * (minIdx + 1);
			}
			res = (res + sum) % (long)(Math.pow(10, 9) + 7);
		}
		return (int) res;
	}

	public static void main(String[] args) {
		SumSubarrayMins sum = new SumSubarrayMins();
		System.out.println(sum.sumSubarrayMins(new int[] {3,1,2,4}));
		System.out.println(sum.sumSubarrayMins(new int[] {11,81,94,43,3}));
	}
}