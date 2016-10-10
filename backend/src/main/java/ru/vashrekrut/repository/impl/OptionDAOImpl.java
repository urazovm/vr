package ru.vashrekrut.repository.impl;

import org.springframework.stereotype.Repository;
import ru.vashrekrut.domain.examination.Option;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.OptionDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
public class OptionDAOImpl
        extends GenericDAOImpl<Option, UUID>
        implements OptionDAO {
    public List getQuestionOptions(UUID questionId) {
        Map<String, Object> criterias = new HashMap<>();
        criterias.put("qss_id", questionId);
        return queryList(Option.FIND_BY_QUESTION, criterias);
    }
}
