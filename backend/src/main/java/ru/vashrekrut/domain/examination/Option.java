package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;

@Entity
@Table(name = "options")
@AttributeOverride(name = "id", column = @Column(name = "opt_id"))
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Option.findOptionByQuestion", query = "SELECT o FROM Option o WHERE o.question.id = :qss_id")
public class Option extends DomainObject {
    public static final String FIND_BY_QUESTION = "Option.findOptionByQuestion";

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "qss_id", nullable = false)
    private Question question;

    @Column(name = "opt_text")
    private String text;

    @Column(name = "opt_right")
    private boolean right;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String option) {
        this.text = text;
    }

    public boolean isRight() {
        return right;
    }

    public void setIsRight(boolean right) {
        this.right = right;
    }
}
