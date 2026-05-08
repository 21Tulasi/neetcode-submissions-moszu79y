class PrefixTree {
    Node root;
    class Node
    {
        Node[] children;
        boolean isEndOfWord;
        Node(){
            this.children = new Node[26];
        }
    }
    public PrefixTree() {   
        
        this.root = new Node();
 
    }

    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a']==null){
                temp.children[ch-'a']=new Node();
            }
            if(i!=word.length()-1)
                temp=temp.children[ch-'a'];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a']==null)
                return false;
            if(i!=word.length()-1)
                temp=temp.children[ch-'a'];
        }
        return temp.isEndOfWord;

    }

    public boolean startsWith(String word) {
         Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a']==null)
                return false;
            temp=temp.children[ch-'a'];
        }
        return true;
    }
}
