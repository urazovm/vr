package ru.vashrekrut.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.service.intf.ExaminationService;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
@RestController
public class ExaminationController {
    @Autowired
    ExaminationService examinationService;

    @ResponseBody
    @RequestMapping(value = "examination", method = RequestMethod.GET, produces="application/json")
    public List getExaminations() {
        return examinationService.getExaminations();
    }

    @ResponseBody
    @RequestMapping(value = "examination/{id}", method = RequestMethod.GET, produces="application/json")
    public Examination examination(@PathVariable String id) {
        return examinationService.getExaminationById(UUID.fromString(id));
    }

    @RequestMapping(value = "examination", method = RequestMethod.POST)
    public void save(@RequestBody Examination examination) {
        examinationService.saveExamination(examination);
    }
}
