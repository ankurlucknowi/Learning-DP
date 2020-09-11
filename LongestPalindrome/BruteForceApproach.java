class Solution {
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        for (int sl = s.length(); sl>= 2; sl--) {
            for (int i = 0; i<= s.length() - sl; i++) {
                if (isPalindrome(s.substring(i, i+sl))) {
                    return s.substring(i, i+sl);
                }
            }
        }
        return s.substring(0,1);
    }
    boolean isPalindrome(String s) {
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
