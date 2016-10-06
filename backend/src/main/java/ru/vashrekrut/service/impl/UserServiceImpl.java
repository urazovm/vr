package ru.vashrekrut.service.impl;

import ru.vashrekrut.domain.user.User;
import ru.vashrekrut.service.intf.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by root on 9/1/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setLogin("login");
        return user;
    }
}
