import java.util.List;
import java.util.ArrayList;

class GetRowFromEnd {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		ret.add(1);
		if (rowIndex == 0) return ret;
		for (int i = 1; i <= rowIndex; i++) {
			ret.add(1);
			for (int j = i - 1; j > 0; j--) {
				ret.set(j, ret.get(j) + ret.get(j-1));
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		GetRowFromEnd get = new GetRowFromEnd();
		for (int i = 0; i < 10; i++) System.out.println(get.getRow(i));
	}
}