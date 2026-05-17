class Solution {
    public void solve(char[][] board) {
        int rows= board.length;
        int cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[rows][cols];
        for(int i=0;i<cols;i++)
        {
            if(board[0][i]=='O')
            {q.offer(new int[]{0,i});
            visited[0][i]=true;}
        }
        for(int i=0;i<cols;i++)
        {
             if(board[rows-1][i]=='O')
            {
            q.offer(new int[]{rows-1,i});
            visited[rows-1][i]=true;}
        }
        for(int i=1;i<rows-1;i++)
        {
             if(board[i][0]=='O')
            {
            q.offer(new int[]{i,0});
            visited[i][0]=true;}
        }
        for(int i=1;i<rows-1;i++)
        {
             if(board[i][cols-1]=='O')
            {
            q.offer(new int[]{i,cols-1});
            visited[i][cols-1]=true;}
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int[] d:dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && visited[nr][nc]==false && board[nr][nc]=='O'){
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            Arrays.fill(board[i],'X');
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if(visited[i][j])
                    board[i][j]='O';
            }
        }
        
    }
}
