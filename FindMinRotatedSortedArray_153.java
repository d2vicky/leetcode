package leetCodeWeek2;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * 
 * No duplicates. --> O(lgn)
 * @author D2Victoria
 *
 */

public class FindMinRotatedSortedArray_153 {
	// special case of rotated array: not rotated at all
	// 4, 5, 6, 7, 0, 1, 2
	// nums[mid]: which segment it lies in --> (nums[mid] <= nums[END]) ? second : first;
	public int findMin(int[] nums) {
		int start = 0, end = nums.length - 1, mid;
		int last = nums[end];
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] <= last) {
				// second i.e. search to the left
				end = mid;
			} else {
				// first i.e. to the right
				start = mid;
			}
		}
	
		return Math.min(nums[start], nums[end]);
	}
	
	public static void main(String[] args) {
		FindMinRotatedSortedArray_153 test = new FindMinRotatedSortedArray_153();
		// 4, 5, 6, 7, 8, 9, 10, 0, 1, 2 --> 0
		// 3, 4, 5, 6, 7, 8, 9 --> 3
		int[] input1 = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2};
		int[] input2 = {3, 4, 5, 6, 7, 8, 9};
		System.out.println("Min in {4, 5, 6, 7, 8, 9, 10, 0, 1, 2} should be 0: " + test.findMin(input1));
		System.out.println("Min in {3, 4, 5, 6, 7, 8, 9} should be 3: " + test.findMin(input2));
		
	}
}
