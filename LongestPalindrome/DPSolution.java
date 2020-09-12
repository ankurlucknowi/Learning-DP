class Main
{
  public static void main (String args[])
  {
    System.out.
      println (longestPalindrome
	       ("babaddtattarrattatddetartrateedredividerb"));
  }

  public static String longestPalindrome (String s)
  {
    //boundary condition
    if (s.length () <= 1)
      {
	return s;
      }
    Boolean[][]state = new Boolean[s.length ()][s.length ()];

    String longestSubstring = s.substring (0, 1);
    // initiatize base condition
    for (int i = 0; i < s.length (); i++)
      {
	state[i][i] = true;
	if (i != s.length () - 1)
	  {
	    state[i][i + 1] = s.charAt (i) == s.charAt (i + 1);
	    if (state[i][i + 1])
	      longestSubstring = s.substring (i, i + 2);
	  }
      }

    // solve subproblems bottoms up
    for (int i = s.length () - 1; i >= 0; i--)
      {
	for (int j = i; j < s.length (); j++)
	  {
	    if (state[i][j] != null)
	      {
		continue;
	      }
	    state[i][j] = state[i + 1][j - 1] && s.charAt (i) == s.charAt (j);
	    if (state[i][j] && longestSubstring.length () < (j - i + 1))
	      {
		longestSubstring = s.substring (i, j + 1);
	      }
	  }

      }


    return longestSubstring;
  }



}
