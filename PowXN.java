package hw2;
/**
 * Implement pow(x, n).
 * return the value of the first argument x
 * raised to the power of the second argument n.
 * @author D2Victoria
 *
 */
public class PowXN {
	public double myPow(double x, int n) {
		if ( n == 0) {
			return 1.0;
		}
		if (x == 0) { // when x == 0, n is not smaller than 0 by default.. 
			return 0.0;
		}
		
		int N = (n >= 0) ? n : -n;
		double xTo1N1 = xToAbsN(1, x, N);
		return (n >= 0) ? xTo1N1 : (1 / xTo1N1);
		
	}
	
	// key part
	private double xToAbsN(double result, double x, int N) { // N >= 0 && x != 0
		if (N == 0) {
			return result;
		}
		if (N == 1) {
			return result * x;
		}
		
		// N > = 2
		int numOfX = 2;
		double product = x;
		while (numOfX <= N) {
			product *= product;
			numOfX *= 2;
		}
		numOfX /= 2;
		result *= product;
		
		return xToAbsN(result, x, N - numOfX);
	}
	
	public static void main(String[] args) {
		PowXN test = new PowXN();
		System.out.println("1.1 to the 4 => " + Math.pow(1.1, 4) + ": " + test.myPow(1.1, 4));
		System.out.println("4 to the -12 => " + Math.pow(4, -12) + ": " + test.myPow(4, -12));
		System.out.println("0 to the -12 => " + Math.pow(0, 5) + ": " + test.myPow(0, -12));
		System.out.println("5.5 to the 0 => " + Math.pow(5.5, 0) + ": " + test.myPow(5.5, 0));
	}

}
