class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashMap<String,List<String>> hm = new HashMap<>();
        wordList.add(beginWord);
        for(String word:wordList){
            
            for(int i=0;i<word.length();i++){
                StringBuilder s = new StringBuilder(word);
                String str = s.replace(i,i+1,"*").toString();
                hm.computeIfAbsent(str,k->new ArrayList<String>()).add(word);
            }
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.add(beginWord);
        int res=1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int k=0;k<len;k++)
         {   String word = q.poll();
            if(word.equals(endWord))
                    return res;
            

            for(int i=0;i<word.length();i++){
                StringBuilder s = new StringBuilder(word);
                String str = s.replace(i,i+1,"*").toString();
                List<String> sl = hm.get(str);
                for(int j=0;j<sl.size();j++){
                    
                    if(!visited.contains(sl.get(j)))
                    {
                        q.offer(sl.get(j));
                        visited.add(sl.get(j));
                    }
                }
            }
         }
            res++;
        }
        return 0;
    }
}
