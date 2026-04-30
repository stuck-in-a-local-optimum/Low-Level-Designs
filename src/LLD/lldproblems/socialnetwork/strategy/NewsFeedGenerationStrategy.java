package LLD.lldproblems.socialnetwork.strategy;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;

import java.util.List;

public interface NewsFeedGenerationStrategy {

    List<Post> generateFeed(User user);
}
