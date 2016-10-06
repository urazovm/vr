package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "examination_answers")
@AttributeOverride(name = "id", column = @Column(name = "exa_id"))
public class ExaminationAnswer extends Answer {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exr_id", nullable = false)
    private ExaminationResult examinationResult;

    public ExaminationResult getExaminationResult() {
        return examinationResult;
    }

    public void setExaminationResult(ExaminationResult examinationResult) {
        this.examinationResult = examinationResult;
    }
}
