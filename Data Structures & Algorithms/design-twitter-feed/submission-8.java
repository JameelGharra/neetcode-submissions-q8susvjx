class Twitter {

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        // iterate every user that is "relevant"
        // add to their array of posts
        // O(n * m) time and O(n * m) where n users and m posts all over twitter
        // follow data structure would be a set
        // -----------------------

        List<Post> userPosts = postsMap.computeIfAbsent(userId, k -> new ArrayList<>());
        Post post = new Post(timestamp, userId, tweetId);
        timestamp++;
        userPosts.add(post);


        for (Integer follower : followersMap.keySet()) {
            if (!followersMap.get(follower).contains(userId))
                continue;
            List<Post> otherPostsList = postsMap.get(follower);
            if (otherPostsList == null) {
                otherPostsList = new ArrayList<>();
                postsMap.put(follower, otherPostsList);
                otherPostsList.add(post);
                continue;
            }
            otherPostsList.add(post);
            Collections.sort(otherPostsList, (a, b) -> Integer.compare(a.timestamp, b.timestamp));
        }
    }
    Map<Integer, Set<Integer>> followersMap = new HashMap<>();
    Map<Integer, List<Post>> postsMap = new HashMap<>();
    int timestamp = 0;
    private class Post {
        int timestamp;
        int userId;
        int tweetId;
        public Post(int timestamp, int userId, int tweetId) {
            this.timestamp = timestamp;
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Post> posts = postsMap.get(userId);
        if (posts == null)
            return new ArrayList<>();
        int tillIndex = Math.max(0, posts.size() - 10);
        List<Integer> res = new ArrayList<>();
        for (int i = posts.size() - 1; i >= tillIndex; --i) {
            res.add(posts.get(i).tweetId);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return ;
        if (!followersMap.containsKey(followerId)) {
            followersMap.put(followerId, new HashSet<>());
        }
        if (followersMap.get(followerId).contains(followeeId))
            return ;
        followersMap.get(followerId).add(followeeId);
        List<Post> followeePosts = postsMap.get(followeeId);
        List<Post> followerPosts = postsMap.get(followerId);
        if (followeePosts == null)
            return ;
        if (followerPosts == null) {
            followerPosts = new ArrayList<>();
            postsMap.put(followerId, followerPosts);
        }
        for (Post post : followeePosts) {
            if (post.userId == followeeId) {
                followerPosts.add(post);
            }
        }
        Collections.sort(followerPosts, (a, b) -> Integer.compare(a.timestamp, b.timestamp));
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return ;
        Set<Integer> followers = followersMap.get(followerId);
        if (followers == null)
            return ;
        followers.remove(followeeId);
        List<Post> followerPosts = postsMap.get(followerId);
        if (followerPosts == null)
            return ;
        for (int i = followerPosts.size() - 1; i >= 0; --i) {
            if (followerPosts.get(i).userId == followeeId) {
                followerPosts.remove(i);
            }
        }
        followerPosts.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));
    }
    public static void main(String[] args) {

    }
}
