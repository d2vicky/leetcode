package leetCodeWeek2;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * 
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * Duplicates. --> O(n) Black Box
 * @author D2Victoria
 *
 */

public class FindMinRotatedSortedArrayII_154 {
	// Do I need to consider the situation when nums is empty?
	public int findMin(int[] nums) {
		
		if (nums.length == 1) {
			return nums[0];
		}
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		FindMinRotatedSortedArrayII_154 test = new FindMinRotatedSortedArrayII_154();
		int[] nums = {4, 5, 6, 6, 7, 0, 0, 1, 2, 2, 3};
		System.out.println("Min in {4, 5, 6, 6, 7, 0, 0, 1, 2, 2, 3} should be 0: " + test.findMin(nums));
	}
}
