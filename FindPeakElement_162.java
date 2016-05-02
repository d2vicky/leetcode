package leetCodeWeek2;
/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], 
 * find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * [5, 4, 3, 4, 5], return 0 (or 4)?
 * 
 * [1, 2, 3, 1], return the index number 2.
 * 
 * O(lgn)
 * @author D2Victoria
 *
 */

public class FindPeakElement_162 {
	// 1. special case [1, 3] or [5, 2]
	
	public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1, mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return (nums[start] > nums[end]) ? start : end;
	}
	
	public static void main(String[] args) {
		FindPeakElement_162 test = new FindPeakElement_162();
		int[] input1 = {1, 2, 3, 1};
		int[] input2 = {5, 4, 3, 4, 5};
		int[] input3 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] input4 = {9, 6, 5, 3, 2};
		int[] input5 = {5, 2};
		System.out.println("{1, 2, 3, 1} --> 2:" + test.findPeakElement(input1));
		System.out.println("{5, 4, 3, 4, 5} --> 0:" + test.findPeakElement(input2));
		System.out.println("{1, 2, 3, 4, 5, 6, 7, 8} --> 7:" + test.findPeakElement(input3));
		System.out.println("{9, 6, 5, 3, 2} --> 0:" + test.findPeakElement(input4));
		System.out.println("{5, 2} --> 0:" + test.findPeakElement(input5));
	}

}
