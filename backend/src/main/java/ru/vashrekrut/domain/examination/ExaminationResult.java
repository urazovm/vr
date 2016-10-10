package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by root on 9/2/16.
 */
@Entity
@Embeddable
@Table(name = "examination_results")
@AttributeOverride(name = "id", column = @Column(name = "exr_id"))
public class ExaminationResult extends DomainObject {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aex_id", nullable = false)
    private AccountExamination accountExamination;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examinationResult", cascade = CascadeType.ALL)
    private Set<ExaminationOption> examinationOptions;

    @Column(name = "exr_answered")
    private boolean answered;

    public AccountExamination getAccountExamination() {
        return accountExamination;
    }

    public void setAccountExamination(AccountExamination accountExamination) {
        this.accountExamination = accountExamination;
    }

    public Set<ExaminationOption> getExaminationOptions() {
        return examinationOptions;
    }

    public void setExaminationOptions(Set<ExaminationOption> examinationOptions) {
        this.examinationOptions = examinationOptions;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
