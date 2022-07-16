package leetcode;

import java.util.*;

public class Twitter {

    class NewsFeedTweet {
        int count;
        int tweetId;
        int followeeId;
        int index;

        public NewsFeedTweet(int count, int tweetId, int followeeId, int index) {
            this.count = count;
            this.tweetId = tweetId;
            this.followeeId = followeeId;
            this.index = index;
        }
    }

    class Tweet {
        int count;
        int tweetId;

        public Tweet(int count, int tweetId) {
            this.count = count;
            this.tweetId = tweetId;
        }
    }

    int count;
    Map<Integer, List<Tweet>> userToTweets;
    Map<Integer, Set<Integer>> userFollows;
    public Twitter() {
        count = 0;
        userToTweets = new HashMap<>();
        userFollows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userToTweets.putIfAbsent(userId, new ArrayList<>());
        userToTweets.get(userId).add(new Tweet(count, tweetId));
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<NewsFeedTweet> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        userFollows.putIfAbsent(userId, new HashSet<>());
        userFollows.get(userId).add(userId);

        // for all the followers, get their last tweet and put it in the pq. The NewsFeedTweet contains
        // all information to keep on pulling tweets if needed
        for (int followeeId : userFollows.get(userId)) {
            if (userToTweets.containsKey(followeeId)) {
                int index = userToTweets.get(followeeId).size() - 1;
                Tweet tweet = userToTweets.get(followeeId).get(index);
                pq.offer(new NewsFeedTweet(tweet.count, tweet.tweetId, followeeId, index - 1));
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {
            NewsFeedTweet newsFeedTweet = pq.poll();
            res.add(newsFeedTweet.tweetId);
            if (newsFeedTweet.index >= 0) {
                Tweet tweet = userToTweets.get(newsFeedTweet.followeeId).get(newsFeedTweet.index);
                pq.offer(new NewsFeedTweet(tweet.count, tweet.tweetId, newsFeedTweet.followeeId, newsFeedTweet.index - 1));
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userFollows.putIfAbsent(followerId, new HashSet<>());
        userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            if (userFollows.get(followerId).contains(followeeId)) {
                userFollows.get(followerId).remove(followeeId);
            }
        }
    }
}
