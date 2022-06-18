import java.util.List;
import java.util.ArrayList;

class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
        int head = 1; // 二进制
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) res.add(head + res.get(j)); // 倒序添加
            head <<= 1; // 二进制最高位补1（相当于加上一个十进制的数）
        }
        return res;
	}

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(3));
	}
}