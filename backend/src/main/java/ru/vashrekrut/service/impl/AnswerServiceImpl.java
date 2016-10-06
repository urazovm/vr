package ru.vashrekrut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vashrekrut.domain.examination.Answer;
import ru.vashrekrut.repository.intrf.AnswerDAO;
import ru.vashrekrut.service.intf.AnswerService;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO repository;

    @Override
    public List<Answer> getQuestionAnswers(UUID questionId) {
        return repository.getQuestionAnswers(questionId);
    }

    @Override
    public void saveAnswer(Answer answer) {
        repository.save(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        repository.delete(answer);
    }
}
