package LLD.lldproblems.socialnetwork.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private Set<User> friends;
    private List<Post> posts;


    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.friends = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    public void addFriend(User friend){
        this.friends.add(friend);
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
