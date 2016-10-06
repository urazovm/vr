package ru.vashrekrut.repository.impl;

import org.springframework.stereotype.Repository;
import ru.vashrekrut.domain.examination.AccountExamination;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.AccountExaminationDAO;

import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
public class AccountExaminationDAOImpl
        extends GenericDAOImpl<AccountExamination, UUID>
        implements AccountExaminationDAO {

}
