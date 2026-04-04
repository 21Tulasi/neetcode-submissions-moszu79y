class Solution {
    public boolean checkBit(int n,int i){
        if((n&(1<<i))==0)
            return false;
        return true;

    }
    public int getSum(int a, int b) {
        int c=0;
        int ans = 0;
        boolean A = true, B = true;
        
        for(int i=0;i<32;i++){
            A = checkBit(a,0);
            B = checkBit(b,0);
            if((A && B) || (!A && !B))
            {
                ans = (ans) | (c<<i);
                
            }
            else
            {
                ans = (ans) | ((1^c)<<i);
            }
            if(A && B)
                c=1; 
            if(!A && !B)
                c=0; 
            a=a>>1;
            b=b>>1;
        }
        return ans;
    }
}
