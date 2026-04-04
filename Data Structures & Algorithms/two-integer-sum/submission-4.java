class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hm.get(target-nums[i])!=null)
            {
                arr[1]=i;
                arr[0]=hm.get(target-nums[i]);
            }
            hm.put(nums[i],i);
        }
        return arr;
    }
}
