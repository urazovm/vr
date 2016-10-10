package ru.vashrekrut.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vashrekrut.domain.examination.Option;
import ru.vashrekrut.service.intf.OptionService;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
@RestController
public class OptionController {

    @Autowired
    OptionService optionService;

    @ResponseBody
    @RequestMapping(value = "options/{id}", method = RequestMethod.GET, produces="application/json")
    public List<Option> questionOption(@PathVariable String id) {
        return optionService.getQuestionOptions(UUID.fromString(id));
    }
}
