import java.util.Arrays;

class MinMovesToSeat {
	public int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);
		int res = 0;
		for (int i = 0; i < seats.length; i++) res += Math.abs(seats[i] - students[i]);
		return res;
	}

	public static void main(String[] args) {
		MinMovesToSeat mm = new MinMovesToSeat();
		System.out.println(mm.minMovesToSeat(new int[] {3,1,5}, new int[] {2,7,4}));
		System.out.println(mm.minMovesToSeat(new int[] {4,1,5,9}, new int[] {1,3,2,6}));
		System.out.println(mm.minMovesToSeat(new int[] {2,2,6,6}, new int[] {1,3,2,6}));
	}
}