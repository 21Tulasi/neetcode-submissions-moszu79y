class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(i<=j && j<nums.length){
            if(nums[j]==0) {
                j++;
                continue;
            }
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j++;
        }
    }
}