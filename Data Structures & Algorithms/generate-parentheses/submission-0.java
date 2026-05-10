class Solution {
    List<String> l = new ArrayList<>();
    public void backTrack (char[] c,int n,int idx,int open,int close){
        if(idx==n)
        {
            String s = new String(c);
            l.add(s);
            return;
        }
        if(open<n/2)
        {   c[idx]='(';
            backTrack(c,n,idx+1,open+1,close);
        }
        if(close<n/2 && open>close){
            c[idx]=')';
            backTrack(c,n,idx+1,open,close+1);
        }
        return;
        
    }
    public List<String> generateParenthesis(int n) {
        char[] c = new char[2*n];
        backTrack(c,2*n,0,0,0);
        return l;
    }
}


// "",n,0,0,0 -> (,1 
// (,1  ->

