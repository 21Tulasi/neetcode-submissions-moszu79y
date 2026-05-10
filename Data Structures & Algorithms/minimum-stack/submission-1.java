class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst ;

    public MinStack() {
        this.st = new Stack<>();
        this.minst = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || minst.peek()>=val)
            minst.push(val);
    
    }
    
    public void pop() {
        int val = st.peek();
        if(val==minst.peek())
            minst.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
