class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(!hs.contains(n)){
            hs.add(n);
            int ans=0;
            int val = n;
            while(val>0){
                int d=val%10;
                d=d*d;
                val=val/10;
                ans=ans+d;                
            }
            n=ans;
            if(n==1)
                return true;
        }
        return false;
    }
}
