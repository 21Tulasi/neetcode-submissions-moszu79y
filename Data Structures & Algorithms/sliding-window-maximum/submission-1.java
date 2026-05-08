class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new LinkedList<>();
        int ans[] = new int[nums.length-k+1];
        for(int j=0;j<nums.length;j++){
            while(!d.isEmpty() && d.peekFirst()<j-k+1)
            {
                d.pollFirst();
            }
            while(!d.isEmpty() && nums[d.peekLast()]<nums[j]){
                d.pollLast();
            }
            d.offerLast(j);
            if(j-k+1>=0){
                ans[j-k+1]=nums[d.peekFirst()];
                System.out.println("ans:"+ans[j-k+1]+" "+(j-k+1));
            }
            System.out.println(j+" "+d.peekFirst());
           
        }
         return ans;
    }
}
