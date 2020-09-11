import java.util.Date;
import java.util.HashMap;
import java.util.Arrays;

class DP {
 
  	public static void main(String[] args) {
  	    for (int i = 2; i <= 300; i++) {
          long t1 = System.currentTimeMillis();
          System.out.println(i+"*"+f(i)+"*"+(System.currentTimeMillis() - t1));
  	    }

  	}
    static int f(int n) {
       int [] minSteps = new int[n+1];
       minSteps[1] = 0;
        for (int i = 2; i<=n; i++)
        {
           minSteps[i] = Math.min(minSteps[i-1], 
                                    Math.min(
                                       i%2 == 0 ? minSteps[i/2] : Integer.MAX_VALUE ,
                                       i%3 == 0 ? minSteps[i/3] : Integer.MAX_VALUE )
                                ) + 1;
        }
       // System.out.println(Arrays.toString(minSteps));
        return minSteps[n];
    }
}