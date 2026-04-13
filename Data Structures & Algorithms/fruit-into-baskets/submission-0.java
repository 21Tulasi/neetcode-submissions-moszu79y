class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int j=0;j<fruits.length;j++){
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            while(hm.size()>2){
                hm.put(fruits[i],hm.getOrDefault(fruits[i],0)-1);
                if(hm.get(fruits[i])==0)
                    hm.remove(fruits[i]);
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}