class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public void backTrack(boolean[] visited,int[] nums,int[] arr,int idx,int n){
        if(idx==n)
        {
            List<Integer> al = new ArrayList<>();
            for (int x : arr) {
                al.add(x);
            }
            l.add(al);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[idx]=nums[i];
                backTrack(visited,nums,arr,idx+1,n);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int arr[] = new int [nums.length];
        backTrack(visited,nums,arr,0,nums.length);
        return l;
    }
}
