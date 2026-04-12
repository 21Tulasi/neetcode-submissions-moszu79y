class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int ans=0,maxfreq=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int j=0;j<s.length();j++){
            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            maxfreq=Math.max(maxfreq,hm.get(s.charAt(j)));
            while(j-i+1-maxfreq > k){
                hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}
