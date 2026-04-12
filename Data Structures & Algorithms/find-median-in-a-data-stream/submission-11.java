
// bad solution for practice, sorting
class MedianFinder {
    List<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        data.add(num);
        data.sort((a, b) -> Integer.compare(a, b));
    }
    
    public double findMedian() {
        // [1, 2, 3] -> odd its ok
        // [1. 2. 3. 4] -> 0 + 3 = 1.5 = 1
        int leftMid = (data.size() - 1) / 2; 
        if ((data.size() & 1) == 1) {
            return data.get((data.size() - 1) / 2);
        }
        return ((double)data.get(leftMid) + data.get(leftMid + 1)) / 2;
    }
}
