class Solution {
    List<List<Integer>> al = new ArrayList<>();
    public void sum(int[] nums,int target,int i,List<Integer> l){
       
        if(target==0)
        {        
            al.add(new ArrayList(l));
            return;
        }
        if(target<0 || i==nums.length){
            return;
        }
        l.add(nums[i]);
        sum(nums,target-nums[i],i,l);
        l.remove(l.size()-1);
        sum(nums,target,i+1,l);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> l = new ArrayList<>();
        sum(nums,target,0,l);
        return al;
    }
}
