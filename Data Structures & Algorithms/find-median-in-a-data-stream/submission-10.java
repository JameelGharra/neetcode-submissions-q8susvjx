// same as before just less if statements
class MedianFinder {
    // minheap, will always contain more if sizes are different
    PriorityQueue<Integer> highHeap = new PriorityQueue<>();
    // maxheap
    PriorityQueue<Integer> lowHeap = new PriorityQueue<>();

    public MedianFinder() {
        highHeap = new PriorityQueue<>();
        lowHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // we want to make sure that highHeap contains the higher values
        // we "push" it to maxheap to make sure its at root
        // if it is lower than current root it gets heapified if not we poll
        // anyway, so we are good
        lowHeap.offer(num);
        highHeap.offer(lowHeap.poll());
        if (lowHeap.size() + 1 < highHeap.size()) {
            lowHeap.offer(highHeap.poll());
        }
    }
    
    public double findMedian() {
        if (lowHeap.size() != highHeap.size())
            return (double)highHeap.peek();
        double ret = highHeap.isEmpty() ? 
                  lowHeap.peek() :
                  ((double)highHeap.peek() + lowHeap.peek()) / 2;
        return ret;       
    }
}
