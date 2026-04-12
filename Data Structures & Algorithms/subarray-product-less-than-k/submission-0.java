class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int pro=1,ans=0,i=0;
        for(int j=0;j<nums.length;j++){
            pro=pro*nums[j];
            while(i<=j && pro>=k){
                pro=pro/nums[i];
                i++;
            }
            ans=ans+(j-i+1);
        }
        return ans;
    }
}