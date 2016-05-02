package leetCodeWeek2;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 * 
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * Duplicates --> O(n) Black Box
 * @author D2Victoria
 *
 */

public class SearchRotatedSortedArrayII_81 {
	public boolean search(int[] nums, int target) {
		for (int i: nums) {
			if (i == target) {
				return true;
			}
		}
		
		
		return false;
	}
}
