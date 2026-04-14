class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                int op2=st.pop();
                int op1=st.pop();
                int ans = 0;
                if(tokens[i].equals("+"))
                {
                    ans=op1+op2;
                }
                else if(tokens[i].equals("-"))
                {
                    ans=op1-op2;
                }
                else if(tokens[i].equals("*"))
                {
                    ans=op1*op2;
                }
                else if(tokens[i].equals("/"))
                {
                    ans=op1/op2;
                }
                st.push(ans);

            }
        }
        return st.pop();
    }
}