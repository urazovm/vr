package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answers")
@AttributeOverride(name = "id", column = @Column(name = "aws_id"))
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Answer.findAnswerByQuestion", query = "select a from Answer a where a.question.id = :qss_id")
public class Answer extends DomainObject {
    public static final String FIND_BY_QUESTION = "Answer.findAnswerByQuestion";

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "qss_id", nullable = false)
    private Question question;

    @Column(name = "aws_answer")
    private String answer;

    @Column(name = "aws_right")
    private boolean right;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isRight() {
        return right;
    }

    public void setIsRight(boolean right) {
        this.right = right;
    }
}
