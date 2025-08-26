package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {


    private static final List<UserData> USERS = new ArrayList<>();

    static {

        USERS.add(new UserData("admin", "admin123", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));

        USERS.add(new UserData("user", "user123", List.of(Authorities.READ)));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (UserData u : USERS) {
            if (u.username.equals(user) && u.password.equals(password)) {
                return u.authorities;
            }
        }

        return new ArrayList<>();
    }


    private static class UserData {
        String username;
        String password;
        List<Authorities> authorities;

        UserData(String username, String password, List<Authorities> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }
    }
}