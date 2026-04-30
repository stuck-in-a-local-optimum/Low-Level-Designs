package LLD.lldproblems.socialnetwork;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;

import java.util.List;

public class SocialNetworkDemo {
    public static void main(String[] args) {
        SocialNetworkFacade socialNetwork = new SocialNetworkFacade();

        System.out.println("----------- 1. Creating Users -----------");
        User ajeet = socialNetwork.createUser("Ajeet", "ajeet@example.com");
        User rahul = socialNetwork.createUser("Rahul", "rahul@example.com");
        User charlie = socialNetwork.createUser("Charlie", "charlie@example.com");
        System.out.println("Created users: " + ajeet.getName() + ", " + rahul.getName() + ", " + charlie.getName());

        System.out.println("\n----------- 2. Building Friendships -----------");
        socialNetwork.addFriend(ajeet.getId(), rahul.getId());
        socialNetwork.addFriend(rahul.getId(), charlie.getId());
        System.out.println(ajeet.getName() + " and " + rahul.getName() + " are now friends.");
        System.out.println(rahul.getName() + " and " + charlie.getName() + " are now friends.");

        System.out.println("\n----------- 3. Users Create Posts -----------");
        Post ajeetPost = socialNetwork.createPost(ajeet.getId(), "Hello from ajeet!");
        Post rahulPost = socialNetwork.createPost(rahul.getId(), "It's a beautiful day!");
        Post charliePost = socialNetwork.createPost(charlie.getId(), "Thinking about design patterns.");

        System.out.println("\n----------- 4. Users Interact with Posts -----------");
        socialNetwork.addComment(rahul.getId(), ajeetPost.getId(), "Hey ajeet, nice to see you here!");
        socialNetwork.likePost(charlie.getId(), ajeetPost.getId());

        System.out.println("\n----------- 5. Viewing News Feeds (Strategy Pattern) -----------");

        System.out.println("\n--- ajeet's News Feed (should see rahul's post) ---");
        List<Post> ajeetsFeed = socialNetwork.getNewsFeed(ajeet.getId());
        printFeed(ajeetsFeed);

        System.out.println("\n--- rahul's News Feed (should see ajeet's, and Charlie's post) ---");
        List<Post> rahulsFeed = socialNetwork.getNewsFeed(rahul.getId());
        printFeed(rahulsFeed);

        System.out.println("\n--- Charlie's News Feed (should see rahul's post) ---");
        List<Post> charliesFeed = socialNetwork.getNewsFeed(charlie.getId());
        printFeed(charliesFeed);
    }

    private static void printFeed(List<Post> feed) {
        if (feed.isEmpty()) {
            System.out.println("  No posts in the feed.");
            return;
        }
        feed.forEach(post -> {
            System.out.println("  Post by " + post.getAuthor().getName() + " at " + post.getTimestamp());
            System.out.println("    \"" + post.getContent() + "\"");
            System.out.println("    Likes: " + post.getLikes().size() + ", Comments: " + post.getComments().size());
        });
    }
}