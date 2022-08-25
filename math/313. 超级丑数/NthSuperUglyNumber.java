import java.util.PriorityQueue;

class NthSuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long res = 1;
		for (int i = 1; i < n; i++) {
			for (int prime : primes) pq.add(prime * res);
			res = pq.poll();
			while (!pq.isEmpty() && res == pq.peek()) pq.poll();
		}
		return (int) res;
	}

	public static void main(String[] args) {
		NthSuperUglyNumber n = new NthSuperUglyNumber();
		System.out.println(n.nthSuperUglyNumber(12, new int[] {2,7,13,19}));
		System.out.println(n.nthSuperUglyNumber(1, new int[] {2,3,5}));
	}
}