class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ans = 0;
        int l=1,hi=piles[piles.length-1];
        while(l<=hi){
            int mid = l+(hi-l)/2;
            int c=0;
            for(int i=0;i<piles.length;i++)
                c+=(int)Math.ceil(piles[i]/(double)mid);
            System.out.println(c);
            if(c<=h){
                ans=mid;
                hi=mid-1;
            }
            else
                l=mid+1;    
        }
        return ans;
        
    }
}
