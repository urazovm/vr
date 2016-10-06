package ru.vashrekrut.repository.impl;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import ru.vashrekrut.ApplicationTest;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.repository.intrf.ExaminationDAO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/29/16.
 */
public class ExaminationDAOImplTest extends ApplicationTest {

    @Autowired
    private ExaminationDAO examinationDAO;

    @BeforeClass
    @Sql(scripts = "classpath:data.sql")
    public static void setUp() {}

    @AfterClass
    public static void tearDown() {}

    @Test
    public void findExaminationByName() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Static test");
        Assert.assertNotNull(this.examinationDAO.querySingle(Examination.FIND_BY_NAME, params));
    }

    @Test
    public void testGetExaminations() {
        List<Examination> examinations = this.examinationDAO.findAll();
        Assert.assertNotNull(examinations);
    }

    @Test
    public void testSaveExamination() {
        Examination examination = new Examination();
        examination.setName("Тест IQ");
        examination.setDescription("Этот тест предназначен для определения уровня IQ соискателя на вакансию Бухгалтер");
        examination.setPrice(new BigDecimal(123.12));
        this.examinationDAO.save(examination);

        Examination read = this.examinationDAO.read(examination.getId(), false);
        Assert.assertNotNull(read);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDeleteExamination() {
        this.examinationDAO.delete(this.examinationDAO.findExaminationByName("Test to delete"));
        this.examinationDAO.findExaminationByName("Test to delete");
    }

    @Test
    public void testUpdateExamination() {
        Examination examination = this.examinationDAO.findExaminationByName("Test to update");
        examination.setName("Test updated");
        this.examinationDAO.save(examination);

        examination = this.examinationDAO.findExaminationByName("Test updated");
        Assert.assertEquals(examination.getName(), "Test updated");
    }
}