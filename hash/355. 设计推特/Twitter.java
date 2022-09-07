import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

class Twitter {
	Map<Integer, Set<Integer>> followMap;
	Map<Integer, Integer> postMap;
	LinkedList<Integer> timeline;
	
	public Twitter() {
		this.followMap = new HashMap<>();
		this.postMap = new HashMap<>();
		this.timeline = new LinkedList<>();
	}
	
	public void postTweet(int userId, int tweetId) {
		postMap.put(tweetId, userId);
		timeline.addFirst(tweetId);
	}
	
	public List<Integer> getNewsFeed(int userId) {
		followMap.putIfAbsent(userId, new HashSet<>());
		Set<Integer> followSet = followMap.get(userId);
		followSet.add(userId);
		List<Integer> ret = new LinkedList<>();
		for (int i = 0; i < timeline.size(); i++) {
			int tweetId = timeline.get(i);
			int posterId = postMap.get(tweetId);
			if (ret.size() < 10 && followMap.get(userId).contains(posterId)) {
				ret.add(tweetId);
			}
		}
		
		return ret;
	}
	
	public void follow(int followerId, int followeeId) {
		followMap.putIfAbsent(followerId, new HashSet<>());
		followMap.get(followerId).add(followeeId);
	}
	
	public void unfollow(int followerId, int followeeId) {
		followMap.putIfAbsent(followerId, new HashSet<>());
		followMap.get(followerId).remove(followeeId);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */