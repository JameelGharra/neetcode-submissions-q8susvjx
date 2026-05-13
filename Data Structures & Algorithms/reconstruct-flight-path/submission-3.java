class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjMap.computeIfAbsent(ticket.get(0), 
                k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> itinerary = new ArrayList<>();
        dfs("JFK", adjMap, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(
        String airport, 
        Map<String, PriorityQueue<String>> adjMap, 
        List<String> path
    ) {
        PriorityQueue<String> dests = adjMap.get(airport);
        if (dests != null) {
            while (!dests.isEmpty()) {
                dfs(dests.poll(), adjMap, path);
            }
        }
        path.add(airport);
    }
}
