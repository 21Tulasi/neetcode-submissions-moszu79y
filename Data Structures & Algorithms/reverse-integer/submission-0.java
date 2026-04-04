class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0)
        {
            neg=true;
            x=-x;
        }
        int rev=0;
        while(x>0){
            if(rev<(Integer.MIN_VALUE/10)  || rev>(Integer.MAX_VALUE/10))
                return 0;
            if((rev==(Integer.MIN_VALUE/10) && (x%10 < Integer.MIN_VALUE%10))  || (rev==(Integer.MAX_VALUE/10) && (x%10 > Integer.MAX_VALUE%10)))
                return 0;
            rev=(rev*10)+x%10;
            x=x/10;
        }
        return !neg?rev:-rev;
    }
}
