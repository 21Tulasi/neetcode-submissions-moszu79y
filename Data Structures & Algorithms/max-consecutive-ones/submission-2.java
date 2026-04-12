class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,ans=0;
        for(int j=0;j<nums.length;j++){
            while(j<nums.length && nums[j]==0){
                j++;
                i=j;
            }
            if(j<nums.length && nums[j]==1)
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}