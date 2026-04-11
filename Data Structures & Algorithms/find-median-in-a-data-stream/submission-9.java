class MedianFinder {
    // maxheap <---> minheap
    // if maxheap.length == minheap.length
    // eda wa7d akbr mn al thane 3be feh but how?
    // replace when it needs to be
    // if both have same length -> calculate median of them
    // if one is bigger than the other, it is the median

    private PriorityQueue<Integer> minHeap; // up
    private PriorityQueue<Integer> maxHeap; //down

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // minheap
        // maxheap
        if (minHeap.size() == maxHeap.size()) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                int temp =  maxHeap.poll();
                maxHeap.offer(num);
                num = temp;
            }
            minHeap.offer(num);
            return ;
        }
        else { // minheap.size > maxheap.size
            if (minHeap.peek() >= num) {
                maxHeap.offer(num);
            }
            else {
                int temp = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(temp);
            }
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else {
            return minHeap.peek();
        }
    }
}
