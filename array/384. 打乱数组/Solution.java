import java.util.Arrays;
import java.util.Random;

class Solution {
	int[] originArray;
	int[] currArray;
	Random random;
	int n;

	public Solution(int[] nums) {
		this.n = nums.length;
		this.currArray = nums;
		this.originArray = Arrays.copyOfRange(nums, 0, n);
		this.random = new Random();
    }
    
    public int[] reset() {
    	return originArray;
    }

    private void swap(int i, int j) {
    	int temp = currArray[i];
    	currArray[i] = currArray[j];
    	currArray[j] = temp;
    }
    
    public int[] shuffle() {
    	currArray = Arrays.copyOfRange(originArray, 0, n);
    	for (int i = n - 1; i >= 0; i--) {
    		swap(i, random.nextInt(i+1));
    	}
    	return currArray;
    }
}