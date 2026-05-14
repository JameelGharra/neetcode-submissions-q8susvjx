class Solution {
    // same algorithm just iterative
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjMap.computeIfAbsent(
                ticket.get(0), k -> new PriorityQueue<>()
            ).offer(ticket.get(1));
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        LinkedList<String> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            String airport = stack.peek();
            PriorityQueue<String> queue = adjMap.get(airport);
            if (queue == null || queue.isEmpty()) {
                res.addFirst(stack.pop());
            }
            else {
                String next = queue.poll();
                stack.push(next);
            }
        }
        return res;
    }
}
