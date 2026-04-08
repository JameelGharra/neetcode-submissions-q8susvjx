class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> pointData = new ArrayList<>();
        for (int i = 0; i < points.length; ++i) {
            int[] point = points[i];
            pointData.add(new int[]{i, point[0] * point[0] + point[1] * point[1]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int[] entry : pointData) {
            pq.offer(entry);
            if (pq.size() > k)  
                pq.poll();
        }
        int[][] res = new int[k][2];
        Iterator<int[]> iter = pq.iterator();
        while (iter.hasNext()) {
            res[--k] = points[iter.next()[0]];
        }
        return res;
    }
}
