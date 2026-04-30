package LLD.lldproblems.socialnetwork.strategy;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChronologicalStrategy  implements NewsFeedGenerationStrategy {
    @Override
    public List<Post> generateFeed(User user) {
        Set<User> friends = user.getFriends();

        List<Post> friendsPost = new ArrayList<>();

        for(User friend : friends){
            friendsPost.addAll(friend.getPosts());
        }

            //sort posts by timestamp (most recent posts first)
        friendsPost.sort((p1, p2) -> {
            return p2.getTimestamp().compareTo(p1.getTimestamp());
        });

        return friendsPost;
    }
}
