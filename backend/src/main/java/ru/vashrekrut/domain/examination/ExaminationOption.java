package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "examination_options")
@AttributeOverride(name = "id", column = @Column(name = "exo_id"))
public class ExaminationOption extends Option {
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
