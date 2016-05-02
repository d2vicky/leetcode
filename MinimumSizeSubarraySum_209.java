package leetCodeWeek2;
/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * 
 * Given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length, return 2.
 * 
 * @author D2Victoria
 *
 */

public class MinimumSizeSubarraySum_209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min = this.minSubArrayLenFrom(s, nums, 0);
		if (nums.length == 1) {
			return min;
		}
		for(int i = 1; i < nums.length; i++) {
			if (this.minSubArrayLenFrom(s, nums, i) < min) {
				min = this.minSubArrayLenFrom(s, nums, i);
			}
		}
		
		
		
		return min;
	}
	
	private int minSubArrayLenFrom(int s, int[] nums, int start) {
		int result = nums[start], i = 1;
		while (result < s && start < nums.length - 1) {
			start++;
			i++;
			result += nums[start];
		}
		if (start == nums.length - 1 && result < s) {
			return 0;
		} else {
			return i;
		}
	}
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum_209 test = new MinimumSizeSubarraySum_209();
		
	}
}

