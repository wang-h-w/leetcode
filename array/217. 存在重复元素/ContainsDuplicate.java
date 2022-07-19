import java.util.Set;
import java.util.HashSet;

class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) if (!set.add(i)) return true;
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate c = new ContainsDuplicate();
		System.out.println(c.containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(c.containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(c.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}
}