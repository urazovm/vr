package ru.vashrekrut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vashrekrut.domain.examination.Option;
import ru.vashrekrut.repository.intrf.OptionDAO;
import ru.vashrekrut.service.intf.OptionService;

import java.util.List;
import java.util.UUID;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDAO repository;

    @Override
    public List<Option> getQuestionOptions(UUID questionId) {
        return repository.getQuestionOptions(questionId);
    }

    @Override
    public void saveOption(Option option) {
        repository.save(option);
    }

    @Override
    public void deleteOption(Option option) {
        repository.delete(option);
    }
}
