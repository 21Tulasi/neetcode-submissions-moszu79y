class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int pro=1;
        for(int i=0;i<nums.length;i++){
            pro=pro*nums[i];
            ans=Math.max(ans,pro);
            if(pro==0)
                pro=1;
        }
        pro=1;
        for(int i=nums.length-1;i>=0;i--){
            pro=pro*nums[i];
            ans=Math.max(ans,pro);
            if(pro==0)
                pro=1;
        }
        return ans;
    }
}
