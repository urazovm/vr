package ru.vashrekrut.rest;

import ru.vashrekrut.domain.user.User;
import ru.vashrekrut.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 9/1/16.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST, produces="application/json")
    public User login(@RequestBody String login) {
        return  userService.getUserByLogin(login);
    }
}
