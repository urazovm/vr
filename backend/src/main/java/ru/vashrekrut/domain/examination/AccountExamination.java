package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.domain.user.Account;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account_examinations")
@AttributeOverride(name = "id", column = @Column(name = "aex_id"))
public class AccountExamination extends Examination {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id", nullable = false)
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountExamination", cascade = CascadeType.ALL)
    private Set<ExaminationResult> examinationResults;

    @Column(name = "aex_start_time")
    private Date startTime;

    @Column(name = "aex_attempt")
    private boolean attempt;

    @Column(name = "aex_completed")
    private boolean completed;

    @Column(name = "aex_payed")
    private boolean payed;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public boolean isAttempt() {
        return attempt;
    }

    public void setAttempt(boolean attempt) {
        this.attempt = attempt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Set<ExaminationResult> getExaminationResults() {
        return examinationResults;
    }

    public void setExaminationResults(Set<ExaminationResult> examinationResults) {
        this.examinationResults = examinationResults;
    }
}
