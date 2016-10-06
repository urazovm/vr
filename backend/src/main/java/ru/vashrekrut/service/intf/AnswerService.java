package ru.vashrekrut.service.intf;

import ru.vashrekrut.domain.examination.Answer;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
public interface AnswerService {
    List<Answer> getQuestionAnswers(UUID questionId);
    void saveAnswer(Answer answer);
    void deleteAnswer(Answer answer);
}
