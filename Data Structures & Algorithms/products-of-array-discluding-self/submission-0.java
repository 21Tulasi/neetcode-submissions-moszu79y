class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prev[]=new int[nums.length];
        int after[] = new int[nums.length];
        int ans[] = new int[nums.length];
        prev[0]=1;
        for(int i=1;i<nums.length;i++)
        {
                prev[i]=prev[i-1]*nums[i-1];
                System.out.println(prev[i]);
        }
        after[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {   
             after[i]=after[i+1]*nums[i+1];
             System.out.println(after[i+1]);
        }
        for(int i=0;i<nums.length;i++)
        {    
            ans[i]=prev[i]*after[i];
            System.out.println(ans[i]+" "+prev[i]+" "+after[i]);
        }
        return ans;
        
    }
}  
