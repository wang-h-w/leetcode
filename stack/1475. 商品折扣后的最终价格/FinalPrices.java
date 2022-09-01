import java.util.Stack;
import java.util.Arrays;

class FinalPrices {
	public int[] finalPrices(int[] prices) {
		int n = prices.length;
		int[] res = Arrays.copyOfRange(prices, 0, n);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.empty() && prices[stack.peek()] >= prices[i]) {
				int idx = stack.pop();
				res[idx] = prices[idx] - prices[i];
			}
			stack.push(i);
		}

		return res;
	}

	public static void main(String[] args) {
		FinalPrices fp = new FinalPrices();

		int[] res = fp.finalPrices(new int[] {8,4,6,2,3});
		for (int i : res) System.out.print(i + " ");
		System.out.println();

		res = fp.finalPrices(new int[] {1,2,3,4,5});
		for (int i : res) System.out.print(i + " ");
		System.out.println();

		res = fp.finalPrices(new int[] {10,1,1,6});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}