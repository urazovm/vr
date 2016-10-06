package ru.vashrekrut.repository.intrf;

import ru.vashrekrut.domain.examination.Answer;
import ru.vashrekrut.repository.GenericDAO;

import java.util.List;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
public interface AnswerDAO extends GenericDAO<Answer, UUID> {
    List getQuestionAnswers(UUID questionId);
}
