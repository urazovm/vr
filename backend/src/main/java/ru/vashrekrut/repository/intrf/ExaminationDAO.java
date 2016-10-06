package ru.vashrekrut.repository.intrf;

import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.repository.GenericDAO;

import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
public interface ExaminationDAO extends GenericDAO<Examination, UUID> {

    Examination findExaminationByName(String name);
}
