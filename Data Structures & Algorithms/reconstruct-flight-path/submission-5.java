class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjMap.computeIfAbsent(ticket.get(0), 
                k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", adjMap, itinerary);
        return itinerary;
    }

    private void dfs(
        String airport, 
        Map<String, PriorityQueue<String>> adjMap, 
        LinkedList<String> path
    ) {
        PriorityQueue<String> dests = adjMap.get(airport);
        if (dests != null) {
            while (!dests.isEmpty()) {
                dfs(dests.poll(), adjMap, path);
            }
        }
        path.addFirst(airport);
    }
}
