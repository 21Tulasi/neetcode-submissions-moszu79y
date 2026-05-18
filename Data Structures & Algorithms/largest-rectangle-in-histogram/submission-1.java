class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int idx=i;
            int num = nums[i];
            while(!st.isEmpty() && nums[i]<st.peek()[0]){
                num = st.peek()[0];
                idx = st.peek()[1];
                st.pop();
                ans=Math.max(ans,num*(i-idx));
            }
            st.push(new int[]{nums[i],idx});
        }
        while(!st.isEmpty()){
            int num = st.peek()[0];
            int idx = st.peek()[1];
            st.pop();
            ans=Math.max(ans,num*(nums.length-idx));
        }
        return ans;
        
    }
}
