package ru.fivestarter.client.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserJson getUser() {
        UserJson user = new UserJson();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        return user;
    }
}
