package LLD.lldproblems.socialnetwork.observer;

import LLD.lldproblems.socialnetwork.models.Comment;
import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;

public interface PostObserver {
    public void onComment(Post post, Comment comment);
    public void onLike(Post post, User user);
    public void onPostCreated(Post post);
}
