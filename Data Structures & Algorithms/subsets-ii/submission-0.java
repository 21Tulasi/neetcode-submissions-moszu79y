class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();
    public void subset(int[] nums,int i, List<Integer> l){
        if(i==nums.length)
        {
            Collections.sort(l);
            hs.add(new ArrayList(l));
            return;
        }
        l.add(nums[i]);
        subset(nums,i+1,l);
        l.remove(l.size()-1);
        l.add(nums[i]);
subset(nums, i + 1, l);
l.remove(l.size() - 1);

while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
    i++;
}
subset(nums, i + 1, l);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,0,l);
        List<List<Integer>> al = new ArrayList<>();
        for(List<Integer> ll:hs)
            al.add(ll);
        return al;
    }
}
