class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ll = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            int val=-nums[i];
            
            while(left<right)
            {   if(val>nums[right]+nums[left])
                {
                left++;
                }
                else if(val<nums[right]+nums[left])
                {
                right--;
                }
                else{
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[right]);
                    l.add(nums[left]);
                    Collections.sort(l);
                    left++;
                    right--;
                    ll.add(l);
                }
            }
            
        }
        return ll.stream().collect(Collectors.toList());
    }
}
