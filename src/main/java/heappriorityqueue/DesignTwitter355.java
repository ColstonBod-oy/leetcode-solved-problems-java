package heappriorityqueue;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DesignTwitter355 {
  int count;
  HashMap<Integer, List<int[]>> tweetMap;
  HashMap<Integer, HashSet<Integer>> followerMap;
    
  public DesignTwitter355() {
    count = 0;
    tweetMap = new HashMap<>();
    followerMap = new HashMap<>();
  }
    
  public void postTweet(int userId, int tweetId) {
    tweetMap.computeIfAbsent(userId,
      k -> new ArrayList<>()
    );

    tweetMap.computeIfPresent(userId, (k, v) -> {
      v.add(new int[]{count, tweetId});
      return v;
    });

    ++count;
  }
    
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
      Integer.compare(b[0], a[0])
    );

    followerMap.computeIfAbsent(userId,
      k -> new HashSet<>()
    );

    followerMap.get(userId).add(userId);

    followerMap.get(userId).forEach((followeeId) -> {
      if (tweetMap.containsKey(followeeId)) {
        int i = tweetMap.get(followeeId).size() - 1;
        int[] tweet = tweetMap.get(followeeId).get(i);
        pq.offer(new int[]{tweet[0], tweet[1], 
          followeeId, --i});  
      }
    });

    while (!pq.isEmpty() && res.size() < 10) {
      int[] data = pq.poll();
      res.add(data[1]);

      if (data[3] >= 0) {
        int[] tweet = tweetMap.get(data[2]).get(data[3]);
        pq.offer(new int[]{tweet[0], tweet[1], 
          data[2], --data[3]});
      }
    }

    return res;
  }
    
  public void follow(int followerId, int followeeId) {
    followerMap.computeIfAbsent(followerId, 
      k -> new HashSet<>()
    );

    followerMap.computeIfPresent(followerId, (k, v) -> {
      v.add(followeeId);
      return v;
    }); 
  }
    
  public void unfollow(int followerId, int followeeId) {
    HashSet<Integer> set = followerMap.computeIfAbsent(
      followerId, 
      k -> new HashSet<>()
    );

    if (set.contains(followeeId)) {
      set.remove(followeeId);
    }
  }
}