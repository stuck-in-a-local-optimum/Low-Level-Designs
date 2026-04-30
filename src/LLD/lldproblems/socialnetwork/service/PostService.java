package LLD.lldproblems.socialnetwork.service;

import LLD.lldproblems.socialnetwork.models.Comment;
import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.models.User;
import LLD.lldproblems.socialnetwork.observer.PostObserver;
import LLD.lldproblems.socialnetwork.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private PostRepository postRepository ;

    private List<PostObserver> observers;

    public PostService(){
        this.postRepository = PostRepository.getInstance();
        observers = new ArrayList<>();
    }


    public Post createPost(User user, String content){
        Post post = new Post(content, user);
        this.postRepository.savePost(post);
        this.observers.forEach(postObserver -> postObserver.onPostCreated(post));

        return post;

    }


    public void addComment(User author, String commentableId, String content){
        Comment comment = new Comment(content, author);
        Post post = this.postRepository.getPostById(commentableId);
        post.getComments().add(comment);
        //now notify all the observers of this post that a comment added on this post

        this.observers.forEach( postObserver -> postObserver.onComment(post, comment));

    }

    public void likePost(User liker, String postId){
        Post post = this.postRepository.getPostById(postId);
        post.getLikes().add(liker);
        //now notify all the observers of this post that a like added on this post
        this.observers.forEach( postObserver -> postObserver.onLike(post, liker));

    }

    public void addObserver(PostObserver observer){
        this.observers.add(observer);
    }




}
