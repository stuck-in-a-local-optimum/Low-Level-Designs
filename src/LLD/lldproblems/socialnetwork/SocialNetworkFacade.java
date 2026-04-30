package LLD.lldproblems.socialnetwork;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;
import LLD.lldproblems.socialnetwork.observer.UserNotifier;
import LLD.lldproblems.socialnetwork.service.NewsFeedService;
import LLD.lldproblems.socialnetwork.service.PostService;
import LLD.lldproblems.socialnetwork.service.UserService;

import java.util.List;

public class SocialNetworkFacade {
    private final UserService userService;
    private final PostService postService;
    private final NewsFeedService newsFeedService;

    public SocialNetworkFacade() {
        this.userService =  new UserService();
        this.postService = new PostService();
        this.newsFeedService = new NewsFeedService();

        this.postService.addObserver(new UserNotifier());
    }

    public User createUser(String name, String email){
        return  this.userService.createUser(name, email);
    }

    public void addFriend(String userId1, String userId2){
        this.userService.addFriend(userId1, userId2);
    }

    public Post createPost(String authorId, String content){
        User author = this.userService.getUserById(authorId);
        return  this.postService.createPost(author, content);
    }

    public void addComment(String userId, String postId, String content){
        User commentor  = this.userService.getUserById(userId);
        this.postService.addComment(commentor, postId, content);
    }

    public void likePost(String userId, String postId) {
        User user = userService.getUserById(userId);
        postService.likePost(user, postId);
    }

    public List<Post> getNewsFeed(String userId) {
        User user = userService.getUserById(userId);
        return newsFeedService.generateFeed(user);
    }
}
