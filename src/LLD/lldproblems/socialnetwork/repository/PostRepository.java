package LLD.lldproblems.socialnetwork.repository;

import LLD.lldproblems.socialnetwork.models.Post;
import LLD.lldproblems.socialnetwork.observer.PostObserver;
import LLD.lldproblems.socialnetwork.service.PostService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {

    private static PostRepository INSTANCE ;
    private  Map<String, Post> posts;



    private PostRepository(){
        this.posts = new HashMap<>();
    }

    public static  PostRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PostRepository();
        }
        return INSTANCE;

    }

    public Post savePost(Post post) {
        return this.posts.put(post.getId(), post);
    }

    public Post getPostById(String id) {
        return this.posts.get(id);
    }
}
