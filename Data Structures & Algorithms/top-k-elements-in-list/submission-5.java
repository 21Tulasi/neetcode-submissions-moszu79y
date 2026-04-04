class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(Integer num:nums)
            hm.put(num,hm.getOrDefault(num,0)+1);
      List<List<Integer>> ll =new ArrayList<>();
      for(int i=0;i<nums.length+1;i++)
        ll.add(i,new ArrayList<>());
      for(Map.Entry<Integer,Integer> e: hm.entrySet())
      {
            ll.get(e.getValue()).add(e.getKey());
      }
      int res[] = new int[k];
      int i=nums.length;
      int j=0;

      while(j<k && i>0){
       
            for(int l=0;l<ll.get(i).size() && j<k;l++)
            {
                    res[j++]=ll.get(i).get(l);
            }
            i--;

      }

      
      return res;

    }
}
