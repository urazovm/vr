package ru.vashrekrut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/29/16.
 */
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }
}
