package LLD.lldproblems.socialnetwork.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public abstract class CommentableEntity {
    private final String id;
    private final String content;
    private final User author;
    private final Set<User> likes;
    private final List<Comment> comments;

    private final LocalDateTime timestamp; //will be used for feed generation (most recent posts)

    public CommentableEntity(String content, User author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void addLike(User user){
        this.likes.add(user);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
