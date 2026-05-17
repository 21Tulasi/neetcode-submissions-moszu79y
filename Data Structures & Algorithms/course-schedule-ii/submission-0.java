class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int[] indegree = new int[n];
        int[] ans = new int[n];
        for(int i=0;i<numCourses;i++)
            hm.put(i,new LinkedList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            int s = prerequisites[i][1];
            int d = prerequisites[i][0];
            // hm.put(s,hm.get(s).add(d));
            hm.computeIfAbsent(s,k->new LinkedList<>()).add(d);
            indegree[d]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
            {
                 q.offer(i);
            }
        }
        int k=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[k++]=node;
            List<Integer> l = hm.get(node);
            for(int i=0;i<l.size();i++)
            {
                
                indegree[l.get(i)]--;
                if(indegree[l.get(i)]==0)
                    q.offer(l.get(i));
            }
        }
        if(k==n) return ans;
        return new int[]{};

    }
}

