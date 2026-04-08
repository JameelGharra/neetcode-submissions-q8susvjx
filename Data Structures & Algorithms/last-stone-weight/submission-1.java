class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stonesList = Arrays.stream(stones).boxed().map(x -> -x).toList();
        PriorityQueue<Integer> pq = new PriorityQueue<>(stonesList);
        while (pq.size() > 1) {
            int stone1 = -1 * pq.poll();
            int stone2 = -1 * pq.poll();
            if (stone1 > stone2)
                pq.offer(stone2-stone1);
        }
        return !pq.isEmpty() ? -1 * pq.peek() : 0;
    }
}
