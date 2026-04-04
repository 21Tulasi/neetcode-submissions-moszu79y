class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int idx=0;
        for(int i=0;i<nums.length;i++){
        idx = Collections.binarySearch(ans,nums[i]);
        if(idx<0) idx=-idx-1;
        if(idx==ans.size())     
        {
            ans.add(nums[i]);
        }
        else
        {
            ans.set(idx,nums[i]);
        }
            }
        return ans.size();
    }
}
