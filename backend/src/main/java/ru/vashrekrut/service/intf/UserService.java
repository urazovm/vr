package ru.vashrekrut.service.intf;

import ru.vashrekrut.domain.user.User;

public interface UserService {
    User getUserByLogin(String login);
}
