class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int i=0,j=0;
        while(i<=j && j<nums.length){
            
                if(hs.contains(nums[j]))
                    return true;
                hs.add(nums[j]);
                j++;
                if((j-i)>k){
                    hs.remove(nums[i]);
                    i++;
                }
                

        }
        return false;
    }
}