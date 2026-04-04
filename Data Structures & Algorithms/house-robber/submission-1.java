class Solution {
    public int rob(int[] nums) {
        int dpR[]=new int[nums.length+1];
        dpR[0]=0;
        dpR[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            dpR[i]=Math.max(nums[i-1]+dpR[i-2],dpR[i-1]);
        }
        return dpR[nums.length];
        
    }
}
