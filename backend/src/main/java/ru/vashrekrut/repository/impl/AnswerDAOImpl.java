package ru.vashrekrut.repository.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.vashrekrut.domain.examination.Answer;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.AnswerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
public class AnswerDAOImpl
        extends GenericDAOImpl<Answer, UUID>
        implements AnswerDAO {
    public List getQuestionAnswers(UUID questionId) {
        Map<String, Object> criterias = new HashMap<>();
        criterias.put("qss_id", questionId);
        return queryList(Answer.FIND_BY_QUESTION, criterias);
    }
}
