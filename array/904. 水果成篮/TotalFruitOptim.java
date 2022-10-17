class TotalFruit {
	public int totalFruit(int[] fs) {
		int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) tot++;
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) tot--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
	}

	public static void main(String[] args) {
		TotalFruit fruit = new TotalFruit();
		System.out.println(fruit.totalFruit(new int[] {1,2,1}));
		System.out.println(fruit.totalFruit(new int[] {0,1,2,2}));
		System.out.println(fruit.totalFruit(new int[] {1,2,3,2,2}));
		System.out.println(fruit.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
		System.out.println(fruit.totalFruit(new int[] {1,2,3,4,5,6,7}));
	}
}