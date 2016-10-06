package ru.vashrekrut.data;

import ru.vashrekrut.domain.examination.Examination;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/29/16.
 */
public class TestData {

    public static List<Examination> testExaminations() {

        List<Examination> examinations = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Examination examination = new Examination();
            examination.setName("Тест " + i);
            examination.setDescription("Описание теста " + i);
            examination.setPrice(new BigDecimal(i));
            examinations.add(examination);
        }
        return examinations;
    }
}
