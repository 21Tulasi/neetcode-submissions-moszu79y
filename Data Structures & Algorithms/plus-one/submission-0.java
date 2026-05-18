class Solution {
    public int[] plusOne(int[] digits) {
        int c=1;
        Stack<Integer> st = new Stack<>();
        for(int i=digits.length-1;i>=0;i--)
        {
            digits[i]=digits[i]+c;
            st.push(digits[i]%10);
            c=digits[i]/10;     
        }
        if(c!=0)
            st.push(c);
        int ans[] = new int[st.size()];
        int i=0;
        while(!st.isEmpty())
            ans[i++]=st.pop();
        return ans;
    }
}
