package ru.vashrekrut.repository.impl;

import org.springframework.stereotype.Repository;
import ru.vashrekrut.domain.examination.Question;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.QuestionDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
public class QuestionDAOImpl
        extends GenericDAOImpl<Question, UUID>
        implements QuestionDAO {
    public List getExaminationQuestions(UUID examinationId) {
        Map<String, Object> criterias = new HashMap<>();
        criterias.put("exm_id", examinationId);
        return queryList(Question.FIND_BY_EXAMINATION, criterias);
    }
}
