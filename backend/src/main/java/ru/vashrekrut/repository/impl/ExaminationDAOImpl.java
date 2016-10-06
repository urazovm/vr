package ru.vashrekrut.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.repository.GenericDAOImpl;
import ru.vashrekrut.repository.intrf.ExaminationDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
@Repository
@Transactional
public class ExaminationDAOImpl
        extends GenericDAOImpl<Examination, UUID>
        implements ExaminationDAO {

    @Override
    public Examination findExaminationByName(String name) {
        Map<String, Object> criterias = new HashMap<>();
        criterias.put("name", name);
        return querySingle(Examination.FIND_BY_NAME, criterias);
    }
}
