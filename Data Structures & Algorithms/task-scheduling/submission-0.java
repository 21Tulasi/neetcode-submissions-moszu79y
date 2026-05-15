class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<tasks.length;i++)
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(Map.Entry<Character,Integer> e:freq.entrySet())
            pq.offer(e.getValue());
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
           
            if(!pq.isEmpty())
            {int val = pq.poll();
            val=val-1;
            if(val>0)
            q.offer(new int[]{time+n,val});}
             if(!q.isEmpty() && q.peek()[0]==time)
            {
                pq.offer(q.peek()[1]);
                q.poll();
            }

        }
        return time;
    }
}
