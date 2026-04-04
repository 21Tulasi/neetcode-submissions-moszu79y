class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        generate(nums,0,l,new int[nums.length],0);  
        return l;
    }
    public void generate(int[] nums,int idx,List<List<Integer>> l,int[] a,int i){
        if(idx==nums.length){
            List<Integer> al=new ArrayList();
            for(int j=0;j<i;j++)
                al.add(a[j]);
            l.add(al);
            return;
        }
        generate(nums,idx+1,l,a,i);
        a[i]=nums[idx];
        generate(nums,idx+1,l,a,i+1);
    }
}
