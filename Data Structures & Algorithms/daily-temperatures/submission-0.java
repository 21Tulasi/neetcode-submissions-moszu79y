class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
// 0  1  2  3  4  5  6 
// 30,38,30,36,35,40,28

// st 1 2 
// arr  1 _ 
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            
                while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                    int idx = st.pop();
                    res[idx]=i-idx;
                   
                
            }
            st.push(i);
        }
        return res;
    }
}

// 0  1  2  3  4  5  6  7
// 73 74 75 71 69 72 76 73
// st-> 1
// arr-> 1 1 4 2 1 1 0 0 

// 0  1  2  3  4  5  6 
// 30,38,30,36,35,40,28

// st 
// arr 1 4 1 2 1 0 0 



