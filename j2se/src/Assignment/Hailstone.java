package Assignment;
import java.util.ArrayList;
import java.util.List;
public class Hailstone {

    /**
     * Compute the hailstone sequence.
     * See http://en.wikipedia.org/wiki/Collatz_conjecture#Statement_of_the_problem
     * @param n starting number of sequence
     * @return the hailstone sequence starting at n and ending with 1.
     * For example, hailstone(3)=[3,10,5,16,8,4,2,1].
     */
    public static List<Integer> hailstone(int n) {
        List<Integer> l = new ArrayList<Integer>();
        
        while (n != 1) {
            l.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }        
        
        l.add(n); // don't forget the final 1
        return l;
    }
/*
	public static int maxHailstone(int n) {
        int maxV = n;
        
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
			if (n > maxV){
				maxV = n;
			}
        }        
        return maxV;
    }
*/
	/**
	 * Find the largest element in a list.
	 * @param l list of elements.  Requires l to be nonempty and all elements to be nonnegative.
	 * @return the largest element in l
	 */
	public static int max(List<Integer> l) {
/*		int m = 0;
		for (int x : l) {
			if (x > m) {
				m = x;
			}
		}
*/
		int m = l.get(0);
		for(int i=1; i<l.size(); i++){			
			if(l.get(i)>m){
				m = l.get(i);
			}
		}
		return m;
	}
	
	/**
	 * Main program.  Print the peak of the hailstone sequence for a range of starting n's.
	 */
	public static void main(String[] args) {
		
		final int NUM = 3;

		for (int n = 1; n < NUM; n++) {
		    List<Integer> l = hailstone(n);
		    System.out.println(n + " >> " + max(l));
		}

//		System.out.println(NUM + " >> " + maxHailstone(NUM));
	}
}
