class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char s[] = strs[i].toCharArray();
            Arrays.sort(s);
            List<String> l =hm.getOrDefault(new String(s),new ArrayList<>());
            l.add(strs[i]);
            hm.put(new String(s),l);
        }
        List<List<String>> l =new ArrayList<>();
        for(List<String> ll:hm.values())
            l.add(ll);
        return l ;
    }
}
