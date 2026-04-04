class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        return subsetSum(nums,sum/2,0);
        
    }
    public boolean subsetSum(int nums[],int target,int i){
        if(target==0)
            return true;
        if(i==nums.length)
            return false;
        return subsetSum(nums,target-nums[i],i+1)||subsetSum(nums,target,i+1);
    }
}
