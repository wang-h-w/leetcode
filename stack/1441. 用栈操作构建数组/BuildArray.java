import java.util.List;
import java.util.LinkedList;

class BuildArray {
	public List<String> buildArray(int[] target, int n) {
		List<String> ret = new LinkedList<>();
		int curr = 0;
		for (int i = 1; i <= n; i++) {
			if (curr >= target.length) break;
			if (target[curr] == i) {
				ret.add("Push");
				curr++;
			} else if (target[curr] > i) {
				ret.add("Push");
				ret.add("Pop");
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		BuildArray ba = new BuildArray();
		System.out.println(ba.buildArray(new int[] {1,3}, 3));
		System.out.println(ba.buildArray(new int[] {1,2,3}, 3));
		System.out.println(ba.buildArray(new int[] {1,4}, 4));
	}
}