package LLD.lldproblems.socialnetwork.models;

import java.time.LocalDateTime;
import java.util.List;

public class Comment extends CommentableEntity {
    public Comment(String content, User author) {
        super( content, author);
    }

    //replies of a particular comment
    public List<Comment> getReplies(){
        return this.getComments();
    }
}
