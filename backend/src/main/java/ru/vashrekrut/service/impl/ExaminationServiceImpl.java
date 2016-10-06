package ru.vashrekrut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.domain.examination.Question;
import ru.vashrekrut.repository.intrf.ExaminationDAO;
import ru.vashrekrut.service.intf.ExaminationService;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationDAO repository;

    @Override
    public List getExaminations() {
        return repository.findAll();
    }

    @Override
    public List getAccountExamination(UUID accountId) {
        return null;
    }

    @Override
    public Examination getExaminationById(UUID examinationId) {
        return repository.read(examinationId, false);
    }

    @Override
    public List getActiveExaminations(UUID accountId) {
        return null;
    }

    @Override
    public void saveExamination(Examination examination) {
        if (examination.getQuestions() != null) {
            for (Question question : examination.getQuestions()) {
                question.setExamination(examination);
            }
        }

        repository.save(examination);
    }

    @Override
    public void deleteExamination(UUID examinationId) {

    }
}
