import java.util.Date;
import java.util.HashMap;

class ReachToOneRecursively {
  static HashMap<Integer, Integer> repeatedSubProblems = new HashMap();
  static int totalSubProblems = 0;
  	public static void main(String[] args) {
      
      for (int i = 1; i <= 300; i++) {
         repeatedSubProblems = new HashMap();
        totalSubProblems = 0;
          long t1 = System.currentTimeMillis();
          System.out.println(i+"*"+f(i,0)+"*"+(System.currentTimeMillis() - t1)+"*"+totalSubProblems);
      }
      System.out.println(repeatedSubProblems);
		  
  	}
    static int f(int n, int s) {
      if (repeatedSubProblems.containsKey(n)) {
        repeatedSubProblems.put(n, repeatedSubProblems.get(n) +1);
      } else {
        repeatedSubProblems.put(n, 1);
      }
      totalSubProblems++;
      if ( n == 1) {
        return s;
      }
      return Math.min(
        Math.min(f(n-1,s+1), n%2==0 ? f(n/2, s+1) : Integer.MAX_VALUE )
        ,n%3==0 ? f(n/3, s+1) : Integer.MAX_VALUE);
    }
}