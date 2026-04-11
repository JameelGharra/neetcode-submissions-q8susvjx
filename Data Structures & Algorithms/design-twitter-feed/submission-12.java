class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Post>> postsMap;
    int timestamp;

    public Twitter() {
        followMap = new HashMap<>();
        postsMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Post> posts = postsMap.computeIfAbsent(userId, k -> new ArrayList<>());
        posts.add(new Post(timestamp++, userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Post> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.timestamp, b.timestamp) 
        );
        // time - O(n * M log 10) -> O(n 10 log 10 = n)!!! by only 10 posts each followee/user
        // space - O(1)
        if (postsMap.containsKey(userId)) {
            List<Post> userPosts = postsMap.get(userId);
            int earlyIndex = Math.max(0, userPosts.size() - 10);
            for (int i = userPosts.size() - 1; i >= earlyIndex; --i) {
                pq.offer(userPosts.get(i));
                if (pq.size() > 10)
                    pq.poll();
            }
        }
        if (followMap.containsKey(userId)) {
            for (Integer followee : followMap.get(userId)) {
                List<Post> followeePosts = postsMap.get(followee);
                if (followeePosts == null)
                    continue;
                int earlyIndex = Math.max(0, followeePosts.size() - 10);
                for (int i = followeePosts.size() - 1; i >= earlyIndex; --i) {
                    pq.offer(followeePosts.get(i));
                    if (pq.size() > 10)
                        pq.poll();
                }
            }
        }
        List<Integer> tweets = new ArrayList<>();
        while (!pq.isEmpty()) {
            int tweetId = pq.poll().tweetId;
            tweets.add(tweetId);
        }
        Collections.reverse(tweets);
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return ;
        Set<Integer> followees = followMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId) || followerId == followeeId)
            return ;
        followMap.get(followerId).remove(followeeId);
    }
        
    private static class Post {
        int timestamp;
        int userId;
        int tweetId;
        public Post(int timestamp, int userId, int tweetId) {
            this.timestamp = timestamp;
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}
