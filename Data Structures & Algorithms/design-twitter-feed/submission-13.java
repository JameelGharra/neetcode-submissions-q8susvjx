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
        if (posts.size() > 10) {
            posts.remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Post> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.timestamp, b.timestamp) 
        );
        // time - O(n * M log 10) -> O(n 10 log 10 = n)!!! by only 10 posts each followee/user
        // space - O(1)
        // space complexity overall to operate this (including everything): 
        // O(N * M + N*n) where N is the total users, M is 
        // the max amount of posts a user have, n is the 
        // max amount of followees user have
        if (postsMap.containsKey(userId)) {
            List<Post> userPosts = postsMap.get(userId);
            for (int i = userPosts.size() - 1; i >= 0; --i) {
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
                for (int i = followeePosts.size() - 1; i >= 0; --i) {
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
