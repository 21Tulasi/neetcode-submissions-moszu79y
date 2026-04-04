class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char charr[] = strs[i].toCharArray();
            Arrays.sort(charr);
            String s = new String(charr);
            // System.out.println(s+" "+strs[i]);
            ArrayList<String> a = hm.getOrDefault(s,new ArrayList<>());
            a.add(strs[i]);
            hm.put(s,a);
        }
        List<List<String>> l =new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> e: hm.entrySet())
            l.add(e.getValue());
        return l;
    }
}
