class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
            hs.add(nums[i]);
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {   int c=0;
            int j=nums[i]; 
            if(!hs.contains(nums[i]-1))
            while(hs.contains(j)){
                System.out.print((j)+" ");
                c++;
                j++;
            }
            System.out.println();
            ans=Math.max(ans,c);
        }
        return ans;
        
    }
}
