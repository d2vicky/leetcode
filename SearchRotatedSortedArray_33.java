package leetCodeWeek2;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 * 
 * No duplicates --> O(lgn)
 * Duplicates --> O(n) Black Box
 * @author D2Victoria
 *
 */
public class SearchRotatedSortedArray_33 {
	// 1. special case: not rotated at all, i.e. monotonically increasing array
	// 2. run-time complexity O(lgn): binary search
	// 3. nums[mid]: (1) which segment it lies on; (2) which half to dump
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1, mid;
		int first = nums[start], last = nums[end];
		
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[mid] <= last) {
				// nums[mid]: second
				if (nums[mid] < target && target <= last) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				// nums[mid]: first
				if (first <= target && target < nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			}
		}
		
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		
		return -1;
	}
	
	// test cases

}
