class Solution {
    public String longestPalindrome(String s) {
        int ansLen = 0;
        String ans = "";
        for(int i=0;i<s.length();i++){
            int l=i,r=i,resLen=0;
            String res="";
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                resLen=r-l+1;
                res=s.substring(l,r+1);
                l--;
                r++;
            }
            if(ansLen<resLen){
                ansLen=resLen;
                ans=res;
            }
            l=i;
            r=i+1;
            resLen=0;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                resLen=r-l+1;
                res=s.substring(l,r+1);
                l--;
                r++;
            }
            if(ansLen<resLen){
                ansLen=resLen;
                ans=res;
            }
        }
        return ans;
        
    }
}
