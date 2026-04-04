class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1,ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=nums[0]){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        if(ans<nums.length-1)
            return nums[ans+1];
        else
            return nums[0];
        
    }
}
