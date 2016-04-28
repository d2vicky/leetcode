package hw2;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author D2Victoria
 *
 */
public class SqrtX {
	public int mySqrt(int x) {
		if (x < 0) {
			System.out.println("Error: invalid input X!");
			System.exit(0);
		}
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		
		int start = 1, end = x, mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			double squared = (double) mid * mid;
			if (squared == x) {
				return mid;
			} else if (squared > x) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return start; 
	}
	
	public static void main(String[] args) {
		SqrtX test = new SqrtX();
		System.out.println("squre root of 2147395599 is 46339: " + test.mySqrt(2147395599));
		
	}
	

}
