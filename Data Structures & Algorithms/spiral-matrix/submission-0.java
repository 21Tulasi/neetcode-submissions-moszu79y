class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        int r = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> ans= new ArrayList<>();
        while(l<r && top<bottom){
            for(int i=l;i<r;i++)
                ans.add(matrix[top][i]);
            top++;
            for(int i=top;i<bottom;i++)
                ans.add(matrix[i][r-1]);
            r--;
            if(!(l<r && top<bottom))
                break;
            for(int i=r-1;i>=l;i--)
                ans.add(matrix[bottom-1][i]);
            bottom--;
            for(int i=bottom-1;i>=top;i--)
                ans.add(matrix[i][l]);
            l++;
            
        }
        return ans;
    }
}
