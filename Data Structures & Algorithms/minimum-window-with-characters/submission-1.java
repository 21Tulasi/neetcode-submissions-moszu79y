class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm1.put(t.charAt(i),hm1.getOrDefault(t.charAt(i),0)+1);
        }
        int need = hm1.size();
        int have = 0;
        int i=0;
        int ans=Integer.MAX_VALUE;
        String ansString = "";
        for(int j=0;j<s.length();j++){
            hm2.put(s.charAt(j),hm2.getOrDefault(s.charAt(j),0)+1);
            if(hm1.containsKey(s.charAt(j)) && hm1.get(s.charAt(j)).equals(hm2.get(s.charAt(j))))
                have++;
            while(have==need){
                if(ans>j-i+1){
                     ans=Math.min(ans,j-i+1);
                     ansString = s.substring(i,j+1);
                }
                hm2.put(s.charAt(i),hm2.getOrDefault(s.charAt(i),0)-1);
                if(hm1.containsKey(s.charAt(i)) && hm1.get(s.charAt(i))>hm2.get(s.charAt(i)))
                    have--;
                i++;

            }
        }
        return ansString;

        
    }
}
