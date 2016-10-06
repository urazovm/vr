package ru.vashrekrut.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vashrekrut.domain.examination.Answer;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.service.intf.AnswerService;
import ru.vashrekrut.service.intf.ExaminationService;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
@RestController
public class AnswersController {

    @Autowired
    AnswerService answerService;

    @ResponseBody
    @RequestMapping(value = "answers/{id}", method = RequestMethod.GET, produces="application/json")
    public List<Answer> questionAnswers(@PathVariable String id) {
        return answerService.getQuestionAnswers(UUID.fromString(id));
    }
}
