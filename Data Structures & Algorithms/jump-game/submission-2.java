class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = Math.min(nums.length-1,i+nums[i]);
            for(int j=start;j<=end;j++){
                if(dp[i])
                dp[j]=true;
            }
        }
        return dp[nums.length-1];
        
    }
}
