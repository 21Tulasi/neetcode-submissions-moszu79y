class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row =new int[9];
        int[] col = new int[9];
        int[] grid = new int[9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num = board[i][j]-1;
                int r = i;
                int c = j;
                int g = (i/3)*3 + (j/3);

                // 00 01 02 10 11 12 20 21 22 -> 0 0 ->
                // 03 04 05 13 14 15 23 24 25 -> 1 0
                // 06 07 08 16 17 18 26 27 28 -> 2 0

                // 30 31 32 40 41 42 50 51 52 -> 0 1
                // 33 34 35 43 44 45 53 54 55 -> 1 1
                // 36 37 38 46 47 48 56 57 58 -> 2 1

                if((row[r]&(1<<num)) !=0) return false;
                if((col[c]&(1<<num)) !=0) return false;
                if((grid[g]&(1<<num)) !=0) return false;

                row[r]=row[r]|(1<<num);
                col[c]=col[c]|(1<<num);
                grid[g]=grid[g]|(1<<num);
            }
        }
        return true;
        
    }
}
