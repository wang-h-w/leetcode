import java.util.List;
import java.util.LinkedList;

class MajorityElement {
	public List<Integer> majorityElement(int[] nums) {
		int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i) c1++;
            else if (c2 != 0 && b == i) c2++;
            else if (c1 == 0 && ++c1 >= 0) a = i;
            else if (c2 == 0 && ++c2 >= 0) b = i;
            else {
                c1--; c2--;
            }
        }
        c1 = 0; c2 = 0;
        for (int i : nums) {
            if (a == i) c1++;
            else if (b == i) c2++;
        }
        List<Integer> ans = new LinkedList<>();
        if (c1 > n / 3) ans.add(a);
        if (c2 > n / 3) ans.add(b);
        return ans;
	}

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(new int[] {3,2,3}));
		System.out.println(me.majorityElement(new int[] {1,2}));
		System.out.println(me.majorityElement(new int[] {2,2}));
	}
}