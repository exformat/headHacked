package users;

/**
 * Created by Exformat on 11.08.17.
 */
public class User {

    private int id;
    private String nickname;
    private String password;

    public User(int id, String nickName, String password) {
        this.id = id;
        this.nickname = nickName;
        this.password = password;
    }

    public int    getId()      {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

}
