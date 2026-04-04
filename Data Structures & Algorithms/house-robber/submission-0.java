class Solution {
    public int rob(int[] nums) {
        int dpR[]=new int[nums.length+1];
        int dpNR[]=new int[nums.length+1];
        dpR[1]=nums[0];
        dpNR[1]=0;
        for(int i=2;i<nums.length+1;i++){
            dpR[i]=nums[i-1]+dpNR[i-1];
            dpNR[i]=Math.max(dpR[i-1],dpNR[i-1]);
            System.out.println(i+" "+dpR[i]+" "+dpNR[i]);
        }
        return Math.max(dpR[nums.length],dpNR[nums.length]);
        
    }
}
