class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int i=0,j=heights.length-1;
        while(i<j){
            System.out.println(heights[i]+" "+heights[j]);
            int ar = Math.min(heights[i],heights[j])*(j-i);
            area = Math.max(area,ar);
            if(heights[i]<heights[j])
                i++;
            else
            j--;
        }
        return area;
        
    }
}
