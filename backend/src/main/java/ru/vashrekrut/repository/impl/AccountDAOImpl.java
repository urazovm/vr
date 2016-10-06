package ru.vashrekrut.repository.impl;

import org.springframework.stereotype.Repository;
import ru.vashrekrut.domain.user.Account;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.AccountDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
public class AccountDAOImpl
        extends GenericDAOImpl<Account, UUID>
        implements AccountDAO {

    @Override
    public Account findByLogin(String login) {
        Map<String, Object> criterias = new HashMap<>();
        criterias.put("login", login);
        return querySingle(Account.FIND_BY_LOGIN, criterias);
    }
}
