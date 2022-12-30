import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class ExamRoom {
	private TreeSet<int[]> pq;
	private Map<Integer, int[]> prev;
	private Map<Integer, int[]> next;
	private int n;
	private int[] begin;
	private int[] end;

	public ExamRoom(int n) {
		this.pq = new TreeSet<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int len1 = distance(a), len2 = distance(b);
				if (len1 == len2) return b[0] - a[0];
				else return len1 - len2;
			}
		});
		this.prev = new HashMap<>();
		this.next = new HashMap<>();
		this.n = n;
		this.begin = new int[] {-1, -1};
		this.end = new int[] {n, n};
		addInterval(new int[] {0, n - 1});
	}

	public int seat() {
		int[] longest = pq.last();
		int l = longest[0], r = longest[1];
		int seat;
		if (l == 0) seat = l;
		else if (r == n - 1) seat = r;
		else seat = l + (r - l) / 2;
		int[] left = new int[] {l, seat - 1}, right = new int[] {seat + 1, r};
		removeInterval(longest);
		addInterval(left);
		addInterval(right);
		return seat;
	}

	public void leave(int p) {
		int[] left = prev.getOrDefault(p - 1, begin);
		int[] right = next.getOrDefault(p + 1, end);
		int l = p, r = p;
		if (left[0] != -1) {
			l = left[0];
			removeInterval(left);
		}
		if (right[1] != n) {
			r = right[1];
			removeInterval(right);
		}
		addInterval(new int[] {l, r});
	}

	private void addInterval(int[] interval) {
		if (interval[0] > interval[1]) return;
		pq.add(interval);
		prev.put(interval[1], interval);
		next.put(interval[0], interval);
	}

	private void removeInterval(int[] interval) {
		pq.remove(interval);
		prev.remove(interval[1]);
		next.remove(interval[0]);
	}

	private int distance(int[] interval) {
		int l = interval[0], r = interval[1];
		if (l == 0) return r;
		if (r == n - 1) return r - l;
		return (r - l) / 2;
	}

	public static void main(String[] args) {
		ExamRoom er = new ExamRoom(10);
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		er.leave(4);
		System.out.println(er.seat());
		System.out.println("------------");
		er = new ExamRoom(3);
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		er.leave(1);
		System.out.println(er.seat());
	}
}