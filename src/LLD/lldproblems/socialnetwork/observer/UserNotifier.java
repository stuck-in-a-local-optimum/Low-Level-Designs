package LLD.lldproblems.socialnetwork.observer;

import LLD.lldproblems.socialnetwork.models.Comment;
import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;

public class UserNotifier implements PostObserver {
    @Override
    public void onComment(Post post, Comment comment) {
        User author  = post.getAuthor();

        System.out.println("Notification for "+ author.getName()+ ": "+ comment.getAuthor().getName()+ " commented on your post");

    }

    @Override
    public void onLike(Post post, User liker) {
        User author  = post.getAuthor();

        System.out.println("Notification for "+ author.getName()+ ": "+ liker.getName()+ " liked  your post");

    }

    @Override
    public void onPostCreated(Post post) {
        User author = post.getAuthor();

        for(User friend : author.getFriends()){
            System.out.println("Notification for " + friend.getName()+ " :" + author.getName() +" created a new post: "+ post.getContent());
        }

    }
}
