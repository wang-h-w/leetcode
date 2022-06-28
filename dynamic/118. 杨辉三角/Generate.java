import java.util.List;
import java.util.LinkedList;

class Generate {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new LinkedList<>();
		LinkedList<Integer> row = new LinkedList<>();
		row.add(1);
		ret.add(row);
		for (int i = 1; i < numRows; i++) {
			row = new LinkedList<>();
			row.add(1);
			for (int j = 1; j < i; j++) row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
			row.add(1);
			ret.add(row);
		}
		return ret;
	}

	public static void main(String[] args) {
		Generate g = new Generate();
		// for (int i = 1; i < 8; i++) System.out.println(g.generate(i));
		System.out.println(g.generate(5));
	}
}