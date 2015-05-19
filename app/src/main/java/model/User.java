package model;

/**
 * Created by chen on 15-5-19.
 */
public class User {
    private String userId;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User(String passWord, String userId) {
        this.passWord = passWord;
        this.userId = userId;
    }

    public User() {

    }
}
