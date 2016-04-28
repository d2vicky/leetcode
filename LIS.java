package hw2;
/**
 * Given [10, 9, 2, 5, 3, 7, 101, 18]
 * return 4 <= [2, 3, 7, 101]
 * if multiple LISs, just return the length.
 * O(n2) --> O(nlgn)
 * 
 * O(n2) Dynamic
 * Given the input array **nums**
 * Let **sortedNums** be the sorted sequence of nums elements(increasing order)
 * => LCS(nums, sortedNums) returns the length of longest common sequence
 * 
 * O(nlgn)
 * Construct a **set** where set[i] is the smallest end element
 * of an increasing subsequence with the length of i, starting from set[1] = nums[0]
 * Enlarge set while walking through nums elements with the right condition
 * => set.length - 1
 * 
 * ??: duplicated or not? no duplicated items.
 * @author D2Victoria
 *
 */
public class LIS {
	
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int length = nums.length;
		int[] set = new int[length + 1]; // intentionally leave s[0] = 0, with start-end in 
		
		// initialization
		set[1] = nums[0];
		int size = 1; // keep track of current "set.length"
		for (int i = 1; i < length; i++) {
			if (nums[i] > set[size]) {// append nums[i]
				set[size + 1] = nums[i];
				size++;
			}
			else {
				int pos = smallestNotSmaller(nums[i], set, 1, size);// find pos of min >= nums[i]
				set[pos] = nums[i];// replace set[pos] with nums[i]
			}
		}
		
		return size;
		
	}
	
	/**
	 * Given a target, in an array set of set[start]~set[end],
	 * compute the position of smallest element that's not smaller than target.
	 * 
	 * This would only be called under the circumstance that target <= set[end]
	 */
	private int smallestNotSmaller(int target, int[] set, int start, int end) {
		if (start > end) {
			System.out.println("Error: invalid search range!");;
			System.exit(0);
		}
		
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (set[mid] == target) {
				end = mid;
			} else if (set[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (set[start] >= target) {
			return start;
		} else {
			return end;
		}
		
	}
	
	public static void main(String[] args) {
		LIS test = new LIS();
		int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums2 = new int[0];
		int[] nums3 = {1, 2, 3, 4, 5, 7, 11, 18};
		
		System.out.println("(1) LIS should be 4: " + test.lengthOfLIS(nums1));
		System.out.println("(2) LIS should be 0: " + test.lengthOfLIS(nums2));
		System.out.println("(3) LIS should be 8: " + test.lengthOfLIS(nums3));
	}
}
