class PrevPermOpt1 {
	public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        return arr;
    }
}