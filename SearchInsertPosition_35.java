package leetCodeWeek2;
/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * No duplicates.
 * 
 * [1,3,5,6], 5 --> 2
 * [1,3,5,6], 2 --> 1
 * [1,3,5,6], 7 --> 4
 * [1,3,5,6], 0 --> 0
 * 
 * @author D2Victoria
 *
 */

public class SearchInsertPosition_35 {
	public int searchInsert(int[] nums, int target) {
		// search for the **first** element in nums, which is
		// not smaller than target
		// insert to the left
		
		// 1. "insert to the left of some index i" means take the index i as its own
		int start = 0, end = nums.length - 1, mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;// searching for the **first**
			} else if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		// discuss where to insert depending on mainly whether target is found or not
		// [start, end] 1. [<t, t] [<t, >t]; 2. [=t, t] [>t, >t]; 3. [<t, <t]
		if (nums[end] >= target) {
			if (nums[start] < target) {
				return start + 1;
			} else {
				return start;
			}
		} else {
			return end + 1; // or nums.length;
		}
		
	}
	
	public static void main(String[] args) {
		SearchInsertPosition_35 test = new SearchInsertPosition_35();
		int[] nums = {1, 3, 5, 6};
		System.out.println("Inserting Position of 5, 2, 7, 0 \nshould accordingly be 2, 1, 4, 0");
		System.out.println("Test Result:          " + test.searchInsert(nums, 5) + ", " + test.searchInsert(nums, 2) + ", " + test.searchInsert(nums, 7) + ", " + test.searchInsert(nums, 0));
	}

}
