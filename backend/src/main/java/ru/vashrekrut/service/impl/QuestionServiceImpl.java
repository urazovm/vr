package ru.vashrekrut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vashrekrut.domain.examination.Question;
import ru.vashrekrut.repository.intrf.QuestionDAO;
import ru.vashrekrut.service.intf.QuestionService;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO repository;

    @Override
    public List getExaminationQuestions(UUID examinationId) {
        return repository.getExaminationQuestions(examinationId);
    }

    @Override
    public boolean saveQuestion(Question question) {
        return false;
    }

    @Override
    public boolean deleteQuestion(String questionId) {
        return false;
    }


}
