class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEndOfWord;
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    int rows;
    int cols;
    boolean[][] path_visited;
    char[][] board;
    List<String> ans=new ArrayList<>();
    void addWord(String word){
        TrieNode temp=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(temp.children[c-'a']==null){
                temp.children[c-'a']=new TrieNode();
            }
            temp=temp.children[c-'a'];
        }
        temp.isEndOfWord=true; 
    }

    public void dfs(int i,int j,TrieNode node,String word){
        if(i<0 || i>=rows || j<0 || j>=cols || path_visited[i][j] || node.children[board[i][j]-'a']==null )
            return;
        path_visited[i][j]=true;
        node = node.children[board[i][j]-'a'];
        word=word+board[i][j];
        if (node.isEndOfWord && !ans.contains(word))
            ans.add(word);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d:dir){
            int nr = i+d[0];
            int nc = j+d[1];
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && !path_visited[nr][nc]){
                dfs(nr,nc,node,word);
            }
        }
        path_visited[i][j]=false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        for(String w:words)
            addWord(w);
        this.rows = board.length;
        this.cols = board[0].length;
        this.path_visited=new boolean[rows][cols];
        this.board=board;
       for (int i = 0; i < rows; i++)       
            for (int j = 0; j < cols; j++)
                dfs(i, j, root, "");
        return ans;

    }
}
