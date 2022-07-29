import java.util.Queue;
import java.util.PriorityQueue;

class NthUglyNumber {
	public int nthUglyNumber(int n) {
		if (n <= 5) return n; 
		Queue<Long> pq = new PriorityQueue<>();
		long min = 0;
		pq.offer(1L);
		while (n-- != 0) {
			min = pq.poll();
			if (!pq.contains(min * 2)) pq.offer(min * 2);
			if (!pq.contains(min * 3)) pq.offer(min * 3);
			if (!pq.contains(min * 5)) pq.offer(min * 5);
		}

		return (int)min;
	}

	public static void main(String[] args) {
		NthUglyNumber n = new NthUglyNumber();
		System.out.println(n.nthUglyNumber(10));
		System.out.println(n.nthUglyNumber(1407));
	}
}