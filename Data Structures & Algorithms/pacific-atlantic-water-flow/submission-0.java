class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visitedP = new boolean[rows][cols];
        boolean[][] visitedA = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<cols;i++)
        {    
            visitedP[0][i]=true;
            q.offer(new int[]{0,i});
        }
        for(int i=1;i<rows;i++)
        {
             visitedP[i][0]=true;
             q.offer(new int[]{i,0});
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir:dirs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && heights[r][c]<=heights[nr][nc] && visitedP[nr][nc]==false)
                     {   visitedP[nr][nc]=true;
                         q.offer(new int[]{nr,nc});
                     }
                }
            }
        }
        q = new LinkedList<>();
        for(int i=0;i<cols;i++)
        {    
            visitedA[rows-1][i]=true;
            q.offer(new int[]{rows-1,i});
        }
        for(int i=0;i<rows-1;i++)
        {
             visitedA[i][cols-1]=true;
             q.offer(new int[]{i,cols-1});
        }
       
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir:dirs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && heights[r][c]<=heights[nr][nc] && visitedA[nr][nc]==false)
                     {   visitedA[nr][nc]=true;
                        q.offer(new int[]{nr,nc});
                     }
                }
            }
        }
        List<List<Integer>> ll = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                List<Integer> l =new LinkedList<>();
                if(visitedP[i][j] && visitedA[i][j])
                {
                    l.add(i);
                    l.add(j);
                    ll.add(l);
                }
            }
            
        }
        return ll;
        
    }
}
