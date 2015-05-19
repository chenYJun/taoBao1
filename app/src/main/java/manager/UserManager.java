package manager;

import daoImpl.UserService;
import model.User;
import service.IUserService;

/**
 * Created by chen on 15-5-19.
 */
public class UserManager {
    private IUserService dao;
    public UserManager(){
        dao = new UserService();
    }

    /**
     * 登陆，成功返回登陆成功用户的实体，失败返回null
     * @param userId
     * @param passWord
     * @return
     */
    public User Login(String userId, String passWord) {
        User user = dao.getUserById(userId);
        if (user != null) {
            return user.getPassWord().equals(passWord)?user:null;
        }
        return null;
    }

    /**
     * 注册，成功返回用户实体，失败返回null
     * @param user
     * @return
     */
    public User Register(User user) {
        try {
            this.dao.Insert(user);
            return user;
        } catch (Exception e) {
            return  null;
        }


    }
}
