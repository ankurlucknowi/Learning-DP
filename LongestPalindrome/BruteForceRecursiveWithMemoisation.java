
class BruteForceRecursiveWithMemoisation {

    HashMap<String, String> memory = new HashMap();
    
    public static void main(String args[]) {
        // fails for very large strings like "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
    
    
    
    
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        } 
        
        return longestPalindromeSub(s);
    }
    
    // LP(Str(0..n)) = MaxSize of LP(Str(0..(n-1))), LP(Str(1..n)))
    
    String longestPalindromeSub(String s) {
        
        
        if (s.length() <= 1) {
            return s;
        } 
        
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        
        if (isPalindrome(s)) {
            return s;
        }
        
        
        String plLeft = longestPalindromeSub(s.substring(1));
        String plRight = longestPalindromeSub(s.substring(0,s.length()-1));
        
        String retValue = "";
        
        if (plLeft.isEmpty() && plRight.isEmpty()) {
            retValue = "";
        } else if(!plLeft.isEmpty() && plRight.isEmpty()) {
            retValue = plLeft;
        } else if(plLeft.isEmpty() && !plRight.isEmpty()) {
            retValue = plRight;
        } else {
        retValue = plLeft.length() > plRight.length() ? plLeft : plRight;
        }
        
        memory.put(s, retValue);
        return retValue;
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
