class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.offer(minHeap.poll());
        }
        else if (maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==0 && minHeap.size()==0)
            return 0;
        if(maxHeap.size()==0)
            return minHeap.peek();
        if(minHeap.size()==0)
            return maxHeap.peek();
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else
            return maxHeap.peek();
        
        
    }
}
