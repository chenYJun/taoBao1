package daoImpl;

import java.util.HashMap;
import java.util.Map;

import model.User;
import service.IUserService;

/**
 * Created by chen on 15-5-19.
 */
public class UserService implements IUserService {

    private Map<String, User> users = null;


    public UserService() {
        users = new HashMap<String, User>();
        User user = new User("admin", "admin");
        this.Insert(user);
    }

    @Override
    public User getUserById(String userId) {
        return users.get(userId);
    }

    @Override
    public void Insert(User user) {
        users.put(user.getUserId(), user);

    }
}
