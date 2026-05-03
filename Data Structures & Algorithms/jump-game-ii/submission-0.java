class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = Math.min(nums.length-1,i+nums[i]);
            for(int j=start;j<=end;j++){
                if(dp[i]!=Integer.MAX_VALUE)
                {
                    dp[j]=Math.min(dp[j],dp[i]+1);
                }
            }
        }
        return dp[nums.length-1];
        
    }
}
