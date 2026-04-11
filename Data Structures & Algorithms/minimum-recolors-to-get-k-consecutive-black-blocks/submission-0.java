class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0,j=0,w=0,ans=blocks.length();
        while(i<=j && j<blocks.length()){
            if(blocks.charAt(j)=='W')
                w++;
            
            if(j-i+1>=k){
                ans=Math.min(ans,w);
                
                if(blocks.charAt(i)=='W')
                w--; 
                i++;
            }
            j++;
            
        }
        return ans;
        
    }
}