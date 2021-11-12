

import java.util.List;

public class Recursion {

	/**
	 * 
	 * Takes two parameters s1 and s2 of type List<Integer> 
	 * The integers in s1 and s2 appear in non-decreasing order 
	 * 
	 * Returns one int[] containing all the integers from s1 and s2 in non-decreasing order 
	 * Your can modify s1 and s2 if you want and my solution leaves s1 and s2 empty.
	 * 
	 * You will want to use a helper function for this one.
	 * 
	 * See RecursionTest.java for 5 example calls
	 * 
	 */
	public static int[] join(List<Integer> s1, List<Integer> s2) {
		int[] output = new int[s1.size()+s2.size()];
		return joinHelper(s1,s2,output,0);
	}
	
	private static int[] joinHelper(List<Integer> s1, List<Integer> s2, int[] output, int index) {
		if(index >= output.length) {
			return output;
		}
		if(s1.isEmpty()) {
			output[index] = s2.remove(0);
			return joinHelper(s1,s2,output, index+1);
		}
		if(s2.isEmpty()) {
			output[index] = s1.remove(0);
			return joinHelper(s1,s2,output, index+1);
		}
			
		if(s1.get(0)<=s2.get(0)) {
			output[index] = s1.remove(0);
		}else {
			output[index] = s2.remove(0);
		}
		return joinHelper(s1,s2,output, index+1);
	}

	// **************************************************************

	/**
	 * 
	 * Takes a string s and and a character c 
	 * 
	 * Returns the index of the last location that c appears in s 
	 * 
	 * This solution does not require a helper function but you may find it handy to use one.
	 * 
	 * If c is not in s, then returns -1
	 * 
	 * See RecursionTest.java for 6 example calls
	 */
	public static int lastLocation(String s, char c) {
		
		return Integer.MIN_VALUE;
	}

	// **************************************************************

	/**
	 * 
	 * Takes two parameters, subString and huntingGround 
	 * 
	 * Returns the count of the max number of times that subString appears 
	 * consecutively (i.e., back-to-back) in string huntingGround
	 * 
	 * You will want to use a helper function for this one.
	 * 
	 * e.g.
	 * "XX" and "qXXXXqXX" returns 2 because the first XXXX is two repetitions
	 * and the second XX is one repetition
	 * 
	 * See RecursionTest.java for 9 example calls
	 */
	public static int countConsequtiveTimesSubstringAppears(String subString, String huntingGround) {
		return Integer.MIN_VALUE;
	}
	
	// **************************************************************

	/**
	 *  Takes two int parameters, x and logX
	 *  
	 *  Returns true iff log2(x) = logX
	 *  Where log2 means log base 2
	 *  eg
	 *  isExactlyLog2Of(8,3) returns true because 2^3 = 8
	 *  
	 *  See RecursionTest.java for 4 example calls
	 */
	public static boolean isExactLog2Of(int x, int logX) {
		return false;
	}
	
}
