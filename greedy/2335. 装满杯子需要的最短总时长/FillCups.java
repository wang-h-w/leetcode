import java.util.Arrays;

class FillCups {
	public int fillCups(int[] amount) {
		Arrays.sort(amount);
		if (amount[0] + amount[1] > amount[2]) {
			int t = amount[0] + amount[1] - amount[2];
            return (t + 1) / 2 + amount[2];
		} else return amount[2];
	}

	public static void main(String[] args) {
		FillCups fc = new FillCups();
		System.out.println(fc.fillCups(new int[] {1,4,2}));
		System.out.println(fc.fillCups(new int[] {5,4,4}));
		System.out.println(fc.fillCups(new int[] {5,0,0}));
	}
}