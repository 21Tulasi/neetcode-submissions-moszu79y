class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        System.out.println(s);
        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j && i<s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && j>=0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(s.charAt(i)!=s.charAt(j))
                    return false;
            i++;
            j--;
                
        }
        return true;
        
    }
}
