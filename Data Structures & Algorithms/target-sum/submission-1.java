class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<>();
    public int backTrack(int nums[],int target,int i){
        if(i==nums.length)
            return target==0?1:0;
        if(hm.containsKey(i) && hm.get(i).containsKey(target))
            return hm.get(i).get(target);
        int ans = 0;
        ans = backTrack(nums,target-nums[i],i+1)+backTrack(nums,target+nums[i],i+1);
        hm.computeIfAbsent(i,k->new HashMap<Integer,Integer>()).put(target,ans);
        return hm.get(i).get(target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return backTrack(nums,target,0);
    }
}


