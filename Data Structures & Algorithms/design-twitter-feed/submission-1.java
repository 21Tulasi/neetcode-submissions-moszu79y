class Twitter {
    int count=0;
    HashMap<Integer,List<int[]>> tweetMap;
    HashMap<Integer,Set<Integer>> followMap;

    public Twitter() {
        count=0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        followMap.computeIfAbsent(userId,k->new HashSet<>()).add(userId);
        for(int id:followMap.get(userId)){
            List<int[]> tweet = tweetMap.get(id);
            if(tweet == null || tweet.isEmpty()) continue;
            int idx = tweet.size()-1;
            minHeap.offer(new int[]{tweet.get(idx)[0],tweet.get(idx)[1],id,idx});
        }
        while(!minHeap.isEmpty() && res.size()<10){
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int idx = curr[3];
            if(idx>0)
            {
                int[] tweet = tweetMap.get(curr[2]).get(idx-1);
                minHeap.offer(new int[]{tweet[0],tweet[1],curr[2],idx-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId,(k,v)->{
            v.remove(followeeId);
            return v;
        });
    }
}
