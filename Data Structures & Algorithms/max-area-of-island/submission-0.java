class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] visited = new int[rows][cols];
        int max=0;
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && visited[i][j]!=-1){
                    int ans=0;
                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j]=1;
                    q.offer(new int[]{i,j});
                    ans++;
                    while(!q.isEmpty()){
                        int r = q.peek()[0];
                        int c = q.peek()[1];
                        q.poll();
                        if(r+1<rows && grid[r+1][c]==1 && visited[r+1][c]!=1)
                        {
                            visited[r+1][c]=1;
                            q.offer(new int[]{r+1,c});
                            ans++;
                        }
                        if(r-1>=0 && grid[r-1][c]==1 && visited[r-1][c]!=1)
                        {
                            visited[r-1][c]=1;
                            q.offer(new int[]{r-1,c});
                            ans++;
                        }
                        if(c+1<cols && grid[r][c+1]==1 && visited[r][c+1]!=1)
                        {
                            visited[r][c+1]=1;
                            q.offer(new int[]{r,c+1});
                            ans++;
                        }
                        if(c-1>=0 && grid[r][c-1]==1 && visited[r][c-1]!=1)
                        {
                            visited[r][c-1]=1;
                            q.offer(new int[]{r,c-1});
                            ans++;
                        }
                    }
                    max =Math.max(ans,max);
                }
            }
        }
        return max;
        
    }
}
