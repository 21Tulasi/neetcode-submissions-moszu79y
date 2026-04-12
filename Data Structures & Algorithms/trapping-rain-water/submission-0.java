class Solution {
    public int trap(int[] height) {
        int leftMax=-1;
        int rightMax=-1;
        int left =0, right =height.length-1;
        int ans=0;
        while(left<=right){
           if(leftMax<=rightMax){
            ans=ans+Math.max(0,leftMax-height[left]);
            leftMax= Math.max(leftMax,height[left]);
            left++;
           }
           else{
            ans=ans+Math.max(0,rightMax-height[right]);
            rightMax= Math.max(rightMax,height[right]);
            right--;
           }

        }
        return ans;
        
    }
}
