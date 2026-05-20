class Solution {
    public int backTrack(int nums[],int target,int i){
        if(i==nums.length)
            return target==0?1:0;
        return backTrack(nums,target-nums[i],i+1)+backTrack(nums,target+nums[i],i+1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return backTrack(nums,target,0);
    }
}


