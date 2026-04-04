class Solution {
    public int search(int[] nums, int target) {
        int d=0;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=nums[0]){
                d=mid;
                l=mid+1;
            }
            else
                h=mid-1;
        }
        System.out.println(d);
        if(d!=nums.length-1)
            d++;
        l=0;
        h=d-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                h=mid-1;
            else
                l=mid+1;
        }
        l=d;
        h=nums.length-1;
        while(l<=h){
            System.out.println(l+" "+h);
            int mid=l+(h-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                h=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
}
