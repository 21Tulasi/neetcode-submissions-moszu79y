class Solution {
    public boolean checkBit(int n,int i){
        if((n&(1<<i))==0)
            return false;
        return true;

    }
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            ans = ans<<1;
            if(checkBit(n,i))
                ans=(ans) | 1;
            
        }
        return ans;
    }
}
