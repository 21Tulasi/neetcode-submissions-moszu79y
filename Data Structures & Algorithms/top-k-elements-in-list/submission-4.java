class Solution {
    public int[] topKFrequent(int[] nums, int target) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            int freq = hm.getOrDefault(num,0);
            hm.put(num,freq+1);
        }
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
                q.offer(new int[]{e.getValue(),e.getKey()});
            if(q.size()>target)
                q.poll();
        }
        int res[] = new int[target];
        for(int i=0;i<target;i++)
            res[i]=q.poll()[1];
        return res;
        
    }
}
