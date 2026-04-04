class Solution {
    public int[] productExceptSelf(int[] nums) {
        int preproduct[]=new int[nums.length];
        preproduct[0]=1;
        for(int i=1;i<nums.length;i++)
            preproduct[i]=preproduct[i-1]*nums[i-1];
        int postproduct[]=new int[nums.length];
        postproduct[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
            postproduct[i]=postproduct[i+1]*nums[i+1];
        for(int i=0;i<nums.length;i++)
            nums[i]=preproduct[i]*postproduct[i];
        return nums;
        
    }
}  
