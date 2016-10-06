package ru.vashrekrut.service.intf;

import ru.vashrekrut.domain.examination.Examination;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 9/4/16.
 */
public interface ExaminationService {
    List getExaminations();
    List<Examination> getAccountExamination(UUID accountId);
    Examination getExaminationById(UUID id);
    List<Examination> getActiveExaminations(UUID accountId);
    void saveExamination(Examination examination);
    void deleteExamination(UUID examinationId);
}
