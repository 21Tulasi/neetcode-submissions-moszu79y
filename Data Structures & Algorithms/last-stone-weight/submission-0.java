class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++)
            pq.offer(stones[i]);
        while(pq.size()>1){
            int max1= pq.poll();
            int max2=pq.poll();
            if(Math.abs(max1-max2)>0)
                pq.offer(Math.abs(max1-max2));
        }
        if(!pq.isEmpty())
            return pq.peek();
        
            return 0;
    }
}
