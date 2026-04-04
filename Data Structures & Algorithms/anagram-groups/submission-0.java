class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> l =new ArrayList<>();
        for(int i=0;i<s.length;i++){
            int count[]=new int[26];
            for(int j=0;j<s[i].length();j++){
                count[s[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append('#');  
            }
            String key = sb.toString();

            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s[i]);
        }
        System.out.println(hm);
        for(List<String> v : hm.values())
            l.add(v); 
        return l;
    }
}
