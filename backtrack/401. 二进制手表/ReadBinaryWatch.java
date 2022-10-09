import java.util.List;
import java.util.LinkedList;

class ReadBinaryWatch {
	private final static int[] times = new int[] {1,2,4,8,11,12,14,18,26,42};
	private List<String> ret;
	private LinkedList<Integer> path;

	public List<String> readBinaryWatch(int turnedOn) {
		ret = new LinkedList<>();
		path = new LinkedList<>();
		backtrack(0, turnedOn);
		return ret;
	}

	private void backtrack(int start, int turnedOn) {
		if (times.length - start < turnedOn) return;
		if (turnedOn == 0) {
			int hour = 0, minute = 0;
			StringBuffer sb = new StringBuffer();
			for (int i : path) {
				if (i < 10) hour += i;
				else minute += i - 10;
			}
			if (hour > 11 || minute > 59) return;
			sb.append(hour);
			sb.append(':');
			if (minute < 10) sb.append('0');
			sb.append(minute);
			ret.add(sb.toString());
		}
		for (int i = start; i < times.length; i++) {
			path.add(times[i]);
			backtrack(i + 1, turnedOn - 1);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		ReadBinaryWatch watch = new ReadBinaryWatch();
		for (int i = 0; i <= 10; i++) {
			System.out.println("===== " + i + " =====");
			System.out.println(watch.readBinaryWatch(i));
		}
	}
}