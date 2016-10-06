package ru.vashrekrut.repository.intrf;

import ru.vashrekrut.domain.user.Account;
import ru.vashrekrut.repository.GenericDAO;

import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
public interface AccountDAO extends GenericDAO<Account, UUID> {
    Account findByLogin(String login);
}
