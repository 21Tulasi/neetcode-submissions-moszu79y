class Solution {
    public int[] topKFrequent(int[] nums, int target) {
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            int freq = hm.getOrDefault(num,0);
            hm.put(num,freq+1);
        }
        for(int k:hm.keySet()){
            if(!q.contains(hm.get(k)))
                q.add(hm.get(k));
        }
        int arr[] = new int[target];
        int i = 0;
        while(i<target){
            int freq = q.poll();
            System.out.println(freq);
            for(int k:hm.keySet())
                if(hm.get(k)==freq && i<target){
                    arr[i++]=k;
                }
        }
        return arr;
    }
}
