class Solution {
    public int rob(int[] nums) {
        int prevR=0,prevR1=0,currR=nums[0],n=nums.length;
        for(int i=2;i<=n;i++){
            currR=Math.max(prevR1+nums[i-1],prevR);
            prevR1=prevR;
            prevR=currR;
        }
        int prevR_=0,prevR1_=0,currR_=nums[0];
        for(int i=1;i<n;i++){
            currR_=Math.max(prevR1_+nums[i-1],prevR_);
            System.out.println(currR_);
            prevR1_=prevR_;
            prevR_=currR_;
        }
        return Math.max(currR_,currR);

        
    }
}
