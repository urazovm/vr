package ru.vashrekrut.repository.intrf;

import ru.vashrekrut.domain.examination.Option;
import ru.vashrekrut.repository.GenericDAO;

import java.util.List;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
public interface OptionDAO extends GenericDAO<Option, UUID> {
    List getQuestionOptions(UUID questionId);
}
