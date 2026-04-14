class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        if(s1.length()==0) return true;
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<s1.length();i++)
            hm1.put(s1.charAt(i),hm1.getOrDefault(s1.charAt(i),0)+1);
        int i=0;
        for(int j=0;j<s2.length();j++){
            hm2.put(s2.charAt(j),hm2.getOrDefault(s2.charAt(j),0)+1);
            if(j-i+1==s1.length()){
                if(hm1.equals(hm2))
                    return true;
                hm2.put(s2.charAt(i),hm2.getOrDefault(s2.charAt(i),0)-1);
                if(hm2.get(s2.charAt(i))==0)
                    hm2.remove(s2.charAt(i));
                i++;
            }
        }
        return false;

        
    }
}
