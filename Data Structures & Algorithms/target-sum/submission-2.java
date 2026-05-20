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
        int n = nums.length;
        hm.computeIfAbsent(0,k->new HashMap<Integer,Integer>()).put(0,1);
        for(int i=0;i<n;i++){
            for(Map.Entry<Integer,Integer> me:hm.get(i).entrySet()){
                int t = me.getKey();
                int c = me.getValue();
            hm.computeIfAbsent(i+1,k->new HashMap<Integer,Integer>()).put(t+nums[i],hm.computeIfAbsent(i+1,k->new HashMap<Integer,Integer>()).getOrDefault(t + nums[i], 0) + c);
            hm.computeIfAbsent(i+1,k->new HashMap<Integer,Integer>()).put(t-nums[i],hm.computeIfAbsent(i+1,k->new HashMap<Integer,Integer>()).getOrDefault(t - nums[i], 0) + c);
            }
        }
        return hm.get(n).getOrDefault(target,0);
        
    }
}


