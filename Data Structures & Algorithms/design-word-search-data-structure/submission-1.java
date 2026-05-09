class WordDictionary {
    public boolean dfs(String word, int idx,Node root){
        Node temp = root;
        for(int i=idx;i<word.length();i++){
            char ch = word.charAt(i);
            if(word.charAt(i)=='.'){
                for(char c='a';c<='z';c++){
                    if(temp.children[c-'a']!=null){
                        if(dfs(word,i+1,temp.children[c-'a']))
                       return true;
                    }
                }
                return false;
            }
            else{
                if(temp.children[ch-'a']==null)
                    return false;
               
                    temp=temp.children[ch-'a'];
            }
        }
        return temp.isEndOfWord;
    }
    Node root;
    class Node{
        Node[] children;
        boolean isEndOfWord;
        Node(){
            this.children = new Node[26];
        }
    }
    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a']==null){
                temp.children[ch-'a']=new Node();
            }
                temp = temp.children[ch-'a'];
        }
        temp.isEndOfWord=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
        

    }
}


















