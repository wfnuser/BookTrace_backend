package booktrace;

import org.springframework.data.annotation.Id;

/**
 * Created by wfnuser on 16/12/24.
 */
public class User {

    @Id
    public String id;

    public String username;
    public String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                id, username, password);
    }

}

