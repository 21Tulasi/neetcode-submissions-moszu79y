class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,ans=0;
        HashSet<Character> hs =new HashSet<>();
        while(i<=j && j<s.length()){
            if(hs.contains(s.charAt(j)))
            {
                hs.remove(s.charAt(i));
                i++;
            }
            else
            {
                hs.add(s.charAt(j));
                ans=Math.max(ans,j-i+1);
                j++;
            }
        }
        return ans;
        
    }


    // not contains -> add , ans update, j++
    // contains -> remove at i, i++

}
