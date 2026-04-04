class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])==null){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(i);
                hm.put(nums[i],al);
            }
            else{
                ArrayList<Integer> al=hm.get(nums[i]);
                al.add(i);
                hm.put(nums[i],al);
            }
        }
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(hm.get(target-nums[i])!=null){
                if(nums[i]==(target-nums[i])){
                    ArrayList<Integer> al=hm.get(target-nums[i]);
                    if(al.size()>1){
                        ans[0]=al.get(0);
                        ans[1]=al.get(1);
                        return ans;
                    }
                }
                else{
                    ArrayList<Integer> al=hm.get(target-nums[i]);
                    
                        ans[0]=i;
                        ans[1]=al.get(0);
                        return ans;
                    
                }
            }
        }
        return ans;
    }
}
