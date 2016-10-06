package ru.vashrekrut.service.intf;

import ru.vashrekrut.domain.examination.Question;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
public interface QuestionService {
    List getExaminationQuestions(UUID examinationId);
    boolean saveQuestion(Question question);
    boolean deleteQuestion(String questionId);
}
