package Twitter;
import java.util.*;
class Twitter {

    private class User {
        int tweetId;
        int tweetTime;

        public User(int tweetId, int tweetTime) {
            this.tweetId = tweetId;
            this.tweetTime = tweetTime;
        }
    }

    private class PairModel {
        int time;
        int id;

        public PairModel(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    // Custom comparator for sorting tweets by time in descending order
    private class MyCmp implements Comparator<PairModel> {
        @Override
        public int compare(PairModel a, PairModel b) {
            return Integer.compare(a.time, b.time);
        }
    }

    private Map<Integer, List<User>> tweets;  // User -> List of Tweets
    private Map<Integer, Set<Integer>> followers;  // User -> Set of Followers
    private int timestamps;
    private final int maxFeed;

    public Twitter() {
        timestamps = 0;
        maxFeed = 10;
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }

    private void getPostHeap(int userId, PriorityQueue<PairModel> topPost) {
        List<User> myTweets = tweets.getOrDefault(userId, new ArrayList<>());
        int sz = myTweets.size();
        int bucketSz = 0;
        for (int i = sz - 1; i >= 0 && bucketSz < maxFeed; i--) {
            topPost.add(new PairModel(myTweets.get(i).tweetTime, myTweets.get(i).tweetId));
            bucketSz++;
            if (topPost.size() > maxFeed) {
                topPost.poll();
            }
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new User(tweetId, ++timestamps));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<PairModel> topPost = new PriorityQueue<>(new MyCmp());

        // Add user's own tweets
        getPostHeap(userId, topPost);

        // Add tweets from followed users
        Set<Integer> followingList = followers.getOrDefault(userId, new HashSet<>());
        for (Integer followItr : followingList) {
            getPostHeap(followItr, topPost);
        }

        List<Integer> myFeed = new ArrayList<>();
        while (!topPost.isEmpty()) {
            myFeed.add(topPost.poll().id);
        }
        Collections.reverse(myFeed);
        return myFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Prevent self-following
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // Test Cases
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);
        twitter.postTweet(2, 201);
        twitter.postTweet(2, 202);

        twitter.follow(1, 2);

        System.out.println("User 1 News Feed: " + twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);

        System.out.println("User 1 News Feed after unfollowing User 2: " + twitter.getNewsFeed(1));
    }
}
