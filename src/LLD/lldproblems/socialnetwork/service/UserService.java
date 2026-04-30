package LLD.lldproblems.socialnetwork.service;

import LLD.lldproblems.socialnetwork.models.User;
import LLD.lldproblems.socialnetwork.repository.UserRepository;

import java.util.Map;

public class UserService {
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = UserRepository.getInstance();
    }



    public User createUser(String name, String email){
        User user = new User(name, email);
        this.userRepository.saveUser(user);
        return user;
    }

    public void addFriend(String userId1,  String userId2){
        User user1 = this.userRepository.getUserById(userId1);
        User user2 = this.userRepository.getUserById(userId2);

        user1.addFriend(user2);
        user2.addFriend(user1);

    }

    public User getUserById(String id){
        return this.userRepository.getUserById(id);
    }
}
