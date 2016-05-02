package leetCodeWeek2;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * 
 * if the merged array has even number of elements, return the average of the middle two. 
 * 
 * The overall run time complexity should be O(log (m+n)).
 * @author D2Victoria
 *
 */
public class FindKthInTwoSortedArray_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if ((m + n) % 2 == 1) {
			return this.findKthInTwo(nums1, 0, nums2, 0, (m + n) / 2 + 1);
		} else {
			double median1 = this.findKthInTwo(nums1, 0, nums2, 0, (m + n) / 2 + 1);
			double median2 = this.findKthInTwo(nums1, 0, nums2, 0, (m + n) / 2);
			return (median1 + median2) / 2;
		}
		
	}
	
	// 1. k >= 1!!    1=< k <= m + n 明白K的意义，所以K只能从1开始
	// 2. when (m + n) % 2 == 0, should find (m + n) / 2 + 1 and (m + n) / 2
	// 3.
	private double findKthInTwo(int[] nums1, int start_1, int[] nums2, int start_2, int k) {
		int key_1, key_2;
		// three edge cases: 2 to stop, 1 to assign key_1 and key_2(Integer.MAX_VALUE)
		// 1.
		if (start_1 >= nums1.length) {
			return nums2[start_2 + k - 1];
		}
		if (start_2 >= nums2.length) {
			return nums1[start_1 + k - 1];
		}
		// 2.
		if (k == 1) {
			return Math.min(nums1[start_1], nums2[start_2]);
		}
		// 3. 
		key_1 = (start_1 + k / 2 - 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[start_1 + k / 2 - 1];
		key_2 = (start_2 + k / 2 - 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[start_2 + k / 2 - 1];
		
		// Recursion Part
		if (key_1 <= key_2) {
			return findKthInTwo(nums1, start_1 + k / 2, nums2, start_2, k - k / 2);
		} else {
			return findKthInTwo(nums1, start_1, nums2, start_2 + k / 2, k - k / 2);
		}
	}
	
	public static void main(String[] args) {
		FindKthInTwoSortedArray_4 test = new FindKthInTwoSortedArray_4();
		int[] nums1 = {1, 3, 4};
		int[] nums2 = {2};
		System.out.println("median is 1.5: " + test.findMedianSortedArrays(nums1, nums2));
		
		int[] merged = new int[4];
		int index = 3, i = 2, j = 0;
		if (nums1[i] > nums2[j]) {
			merged[index--] = nums1[i--];
		}
		System.out.println("{" + merged[0] + ", " + merged[1] + ", " + merged[2] + ", "  + merged[3] + "}");
		System.out.println("index = 2: " + index);
		System.out.println("i = 1: " + i);
		
	}
}
