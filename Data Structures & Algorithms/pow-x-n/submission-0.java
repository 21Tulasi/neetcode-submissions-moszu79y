class Solution {
    public double myPow(double x, int n) {
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        double res = helper(x,Math.abs((long)n));
        return n>0 ? res :1/res;
    }
    public double helper(double x,long n){
        double res=1;
        while(n>0){
            if((n&1)==1){
                res=res*x;
            }
            x=x*x;
            n=n>>1;
        }
        return res;
    }
}
