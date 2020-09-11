class BruteForceRecursive {
    public static void BruteForceRecursive(String args[]) {
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
    
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        } 
        
        return longestPalindromeSub(s);
    }
    
    // LP(Str(0..n)) = MaxSize of LP(Str(0..(n-1))), LP(Str(1..n)))
    
    static String longestPalindromeSub(String s) {
        
        if (s.length() <= 1) {
            return s;
        } 
        
        if (isPalindrome(s)) {
            return s;
        }
        
        String plLeft = longestPalindromeSub(s.substring(1));
        String plRight = longestPalindromeSub(s.substring(0,s.length()-1));
        
        if (plLeft.isEmpty() && plRight.isEmpty()) {
            return "";
        } else if(!plLeft.isEmpty() && plRight.isEmpty()) {
            return plLeft;
        } else if(plLeft.isEmpty() && !plRight.isEmpty()) {
            return plRight;
        } else {
        return plLeft.length() > plRight.length() ? plLeft : plRight;
        }
    }
    
    static boolean isPalindrome(String s) {
       // System.out.println(s);
        int i = 0;
        int j = s.length() -1;
        
        while (i<=j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
