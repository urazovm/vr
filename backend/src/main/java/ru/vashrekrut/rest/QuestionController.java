package ru.vashrekrut.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.domain.examination.Question;
import ru.vashrekrut.service.intf.ExaminationService;
import ru.vashrekrut.service.intf.QuestionService;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @ResponseBody
    @RequestMapping(value = "questions/{examinationId}", method = RequestMethod.GET, produces="application/json")
    public List<Question> questions(@PathVariable String examinationId) {
        return questionService.getExaminationQuestions(UUID.fromString(examinationId));
    }

    @ResponseBody
    @RequestMapping(value = "question", method = RequestMethod.POST, produces="application/json")
    public void save(@RequestBody Question question) {
        questionService.saveQuestion(question);
    }
}
