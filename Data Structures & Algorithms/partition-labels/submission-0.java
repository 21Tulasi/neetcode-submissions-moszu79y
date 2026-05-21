class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,int[]> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int f = hm.get(s.charAt(i))[0];
                hm.put(s.charAt(i),new int[]{f,i});
            }
            else{
                hm.put(s.charAt(i),new int[]{i,i});
            }
            System.out.println(s.charAt(i)+" "+hm.get(s.charAt(i))[0]+" "+hm.get(s.charAt(i))[1]);
        }
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int len=0;
        for(int j=0;j<s.length();j++){
            int l = hm.get(s.charAt(j))[1];
            if(l-i+1>len)
                len=l-i+1;
            System.out.println(i+" "+j+" "+len);
            if(len==j-i+1)
            {
                ans.add(len);
                len=0;
                i=j+1;
            }
        }
        return ans;
        
    }
}

// i   j   len
// 0   0    4
// 0   1    5
// 0   2    5
// 0   3    5
// 0   4    5  -> 
// 5   5    3
// 5   6    5
// 5   7    5
// 5   8    5
// 5   9    5
// 10  10   1
