class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm1= new HashMap<>();
        for(int i=0;i<nums.length;i++)
            hm1.put(nums[i],hm1.getOrDefault(nums[i],0)+1);
        HashMap<Integer,ArrayList<Integer>> hm2= new HashMap<>();
        for(Map.Entry<Integer,Integer> e:hm1.entrySet())
        {    
            hm2.computeIfAbsent(e.getValue(),key -> new ArrayList<>()).add(e.getKey());
        }
        Set<Integer> s = hm2.keySet();
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for(Integer ele:s)
            ts.add(ele);
        int arr[]=new int[k];
        int i=0;
        for(Integer ele:ts)
        {
            ArrayList<Integer> al = hm2.get(ele);
            for(Integer el: al)
            {
                arr[i++]=el;
                if(i==k)
                    return arr;
            }
        }
        return arr;
    }
}
