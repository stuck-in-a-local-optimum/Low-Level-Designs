package LLD.lldproblems.socialnetwork.repository;

import LLD.lldproblems.socialnetwork.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static UserRepository INSTANCE ;

    private Map<String, User> users;


    private UserRepository(){
        this.users = new HashMap<>();
    }

    public static UserRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }



    public void saveUser(User user) {
        this.users.put(user.getId(), user);

    }
    public User getUserById(String id) {
        return this.users.get(id);
    }
}
