package leetcode;

import java.util.*;

public class Twitter {

    class NewsFeedTweet {
        int timestamp;
        int tweetId;
        int followeeId;
        int index;

        public NewsFeedTweet(int count, int tweetId, int followeeId, int index) {
            this.timestamp = count;
            this.tweetId = tweetId;
            this.followeeId = followeeId;
            this.index = index;
        }
    }

    class Tweet {
        int timestamp;
        int tweetId;

        public Tweet(int count, int tweetId) {
            this.timestamp = count;
            this.tweetId = tweetId;
        }
    }

    int timestamp;
    Map<Integer, List<Tweet>> userIdToTweets;
    Map<Integer, Set<Integer>> userIdFollows;
    public Twitter() {
        timestamp = 0;
        userIdToTweets = new HashMap<>();
        userIdFollows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userIdToTweets.putIfAbsent(userId, new ArrayList<>());
        userIdToTweets.get(userId).add(new Tweet(timestamp, tweetId));
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<NewsFeedTweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        userIdFollows.putIfAbsent(userId, new HashSet<>());
        userIdFollows.get(userId).add(userId);

        // for all the followers, get their last tweet and put it in the pq. The NewsFeedTweet contains
        // all information to keep on pulling tweets if needed
        for (int followeeId : userIdFollows.get(userId)) {
            if (userIdToTweets.containsKey(followeeId)) {
                int index = userIdToTweets.get(followeeId).size() - 1;
                Tweet tweet = userIdToTweets.get(followeeId).get(index);
                pq.offer(new NewsFeedTweet(tweet.timestamp, tweet.tweetId, followeeId, index - 1));
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {
            NewsFeedTweet newsFeedTweet = pq.poll();
            res.add(newsFeedTweet.tweetId);
            if (newsFeedTweet.index >= 0) {
                Tweet tweet = userIdToTweets.get(newsFeedTweet.followeeId).get(newsFeedTweet.index);
                pq.offer(new NewsFeedTweet(tweet.timestamp, tweet.tweetId, newsFeedTweet.followeeId, newsFeedTweet.index - 1));
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userIdFollows.putIfAbsent(followerId, new HashSet<>());
        userIdFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userIdFollows.containsKey(followerId)) {
            if (userIdFollows.get(followerId).contains(followeeId)) {
                userIdFollows.get(followerId).remove(followeeId);
            }
        }
    }
}
