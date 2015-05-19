package service;

import model.User;

/**
 * Created by chen on 15-5-19.
 */
public interface IUserService {
    public void Insert(User user);
    public User getUserById(String userId);


}
