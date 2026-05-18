class Solution {
    public int countSubstrings(String s) {
        int ansCnt = 0;
      
        for(int i=0;i<s.length();i++){
            int l=i,r=i,resLen=0;
            String res="";
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                
                 ansCnt++;
                l--;
                r++;
            }
           
            l=i;
            r=i+1;
            resLen=0;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                 ansCnt++;
                l--;
                r++;
            }
           
        }
        return ansCnt;
        
    }
}


