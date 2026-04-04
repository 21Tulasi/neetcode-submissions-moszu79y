class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=0,m=matrix.length,n=matrix[0].length;
        int l=0,h=(m*n)-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            i=mid/(n);
            j=mid%(n);
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                h=mid-1;
            else
                l=mid+1;
            
        }
        return false;
    }
}
