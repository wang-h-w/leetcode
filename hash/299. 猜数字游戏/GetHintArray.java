import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class GetHintArray {
	public String getHint(String secret, String guess) {
		int n = secret.length();
        int a = 0, b = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < n; i++) {
            int c1 = secret.charAt(i) - '0', c2= guess.charAt(i) - '0';
            if (c1 == c2) {
                a++;
            } else {
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }
        for (int i = 0; i < 10; i++) b += Math.min(cnt1[i], cnt2[i]);
        return a + "A" + b + "B";
	}

	public static void main(String[] args) {
		GetHintArray hint = new GetHintArray();
		System.out.println(hint.getHint("1807", "7810"));
		System.out.println(hint.getHint("1123", "0111"));
		System.out.println(hint.getHint("112321", "111212"));
	}
}