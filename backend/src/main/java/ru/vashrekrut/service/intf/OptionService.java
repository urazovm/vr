package ru.vashrekrut.service.intf;

import ru.vashrekrut.domain.examination.Option;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
public interface OptionService {
    List<Option> getQuestionOptions(UUID questionId);
    void saveOption(Option option);
    void deleteOption(Option option);
}
