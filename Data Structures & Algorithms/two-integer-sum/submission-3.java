class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = target-nums[i];
            if(hm.get(val)!=null)
            {
                ans[0]=hm.get(val);
                ans[1]=i;
            }
            else{
                if(hm.get(nums[i])==null){
                    hm.put(nums[i],i);
                }
            }
        }
       return ans; 
    }
}
