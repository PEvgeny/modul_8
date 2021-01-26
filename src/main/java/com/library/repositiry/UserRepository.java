package com.library.repositiry;

import com.library.domain.Role;
import com.library.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepository {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private List<User> userList = Arrays.asList(
        new User(
            "ev",
            bCryptPasswordEncoder.encode("ev"),
            Collections.singletonList(Role.USER)
        ),
        new User(
            "ev1",
            bCryptPasswordEncoder.encode("ev1"),
            Collections.singletonList(Role.USER)
        ),
        new User(
            "user",
            bCryptPasswordEncoder.encode("pass"),
            Collections.singletonList(Role.USER)
        )
    );

    public User getUserByUserName(String userName) {
        return userList.stream().filter(user -> user.getUsername().equals(userName)).findFirst()
            .orElseThrow(null);
    }
}
