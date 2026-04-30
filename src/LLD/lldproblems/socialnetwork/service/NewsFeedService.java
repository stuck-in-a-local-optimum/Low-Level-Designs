package LLD.lldproblems.socialnetwork.service;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;
import LLD.lldproblems.socialnetwork.strategy.ChronologicalStrategy;
import LLD.lldproblems.socialnetwork.strategy.NewsFeedGenerationStrategy;

import java.util.List;

public class NewsFeedService {
    private NewsFeedGenerationStrategy strategy;

    public NewsFeedService(){
        this.strategy = new ChronologicalStrategy(); //default strategy
    }

    public void setStrategy(NewsFeedGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Post> generateFeed(User user){
        return strategy.generateFeed(user);
    }
}
