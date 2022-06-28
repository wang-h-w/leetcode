import java.util.List;
import java.util.ArrayList;

class GetRow {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		ret.add(1);
		if (rowIndex == 0) return ret;
		for (int i = 1; i <= rowIndex; i++) {
			int temp = 1, last = 1;
			for (int j = 1; j < i; j++) {
				temp = ret.get(j-1) + ret.get(j);
				ret.set(j-1, last);
				last = temp;
			}
			ret.set(i-1, last);
			ret.add(1);
		}
		return ret;
	}

	public static void main(String[] args) {
		GetRow get = new GetRow();
		for (int i = 0; i < 10; i++) System.out.println(get.getRow(i));
	}
}