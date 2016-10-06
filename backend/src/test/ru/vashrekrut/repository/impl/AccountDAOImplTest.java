package ru.vashrekrut.repository.impl;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import ru.vashrekrut.ApplicationTest;
import ru.vashrekrut.domain.user.Account;
import ru.vashrekrut.domain.user.AccountRole;
import ru.vashrekrut.domain.user.User;
import ru.vashrekrut.enums.AccountState;
import ru.vashrekrut.enums.Role;
import ru.vashrekrut.repository.intrf.AccountDAO;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 10/2/16.
 */
public class AccountDAOImplTest extends ApplicationTest {

    @Autowired
    private AccountDAO accountDAO;

    @BeforeClass
    @Sql(scripts = "classpath:data.sql")
    public static void init() {}

    @AfterClass
    public static void destroy() {}

    @Test
    public void findByLogin() throws Exception {
        Account account = this.accountDAO.findByLogin("test@mail.ru");
        Assert.assertNotNull(account);

        account = this.accountDAO.findByLogin("unexisted@mail.ru");
        Assert.assertNull(account);
    }

    @Test
    public void createAccount() {
        User user = new User();
        user.setLogin("test@gmail.com");
        user.setCreationDate(new Date());
        user.setPassword("test123");
        Account account = new Account();
        account.setUser(user);
        account.setName("Pall");
        account.setSurname("Anderson");
        account.setPhone("888-88-88");
        account.setState(AccountState.ACTIVE);
        account.setLegal(false);
        account.setLastLoginTime(new Date());
        AccountRole role = new AccountRole();
        role.setRole(Role.ADMIN);
        account.setRoles(new HashSet(Arrays.asList(role)));

        this.accountDAO.save(account);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteAccount() {
        this.accountDAO.delete(this.accountDAO.findByLogin("test@mail.ru"));
        this.accountDAO.findByLogin("test@mail.ru");
    }

    @Test
    public void updateAccount() {
        Account account = this.accountDAO.findByLogin("test@mail.ru");
        account.setName("Account updated");
        this.accountDAO.save(account);

        account = this.accountDAO.findByLogin("test@mail.ru");
        Assert.assertEquals(account.getName(), "Account updated");
    }

}