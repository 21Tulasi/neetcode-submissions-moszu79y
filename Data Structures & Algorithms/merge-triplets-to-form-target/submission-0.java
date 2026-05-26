class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int c0=0;
        int c1=0;
        int c2=0;
        for(int[] trip:triplets){
            if(trip[0]<=target[0] && trip[1]<=target[1] && trip[2]<=target[2]){
                if(trip[0]==target[0])
                    c0=1;
                if(trip[1]==target[1])
                    c1=1;
                if(trip[2]==target[2])
                    c2=1;     
            }
        }
        return ((c1==1 && c0==1 && c2==1));
    }
}
