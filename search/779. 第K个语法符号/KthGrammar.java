class KthGrammar {
	public int kthGrammar(int n, int k) {
		if (n == 1 || k == 1) return 0;
		int num = kthGrammar(n - 1, (k + 1) / 2);
		if (num == 0) {
			if (k % 2 != 0) return 0;
			else return 1;
		} else {
			if (k % 2 != 0) return 1;
			else return 0;
		}
	}

	public static void main(String[] args) {
		KthGrammar kg = new KthGrammar();
		System.out.println(kg.kthGrammar(1,1));
		System.out.println(kg.kthGrammar(2,1));
		System.out.println(kg.kthGrammar(2,2));
		System.out.println(kg.kthGrammar(19,2373));
	}
}