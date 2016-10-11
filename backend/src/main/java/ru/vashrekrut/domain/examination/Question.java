package ru.vashrekrut.domain.examination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.enums.QuestionType;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 9/2/16.
 */
@Entity
@Table(name = "questions")
@AttributeOverride(name = "id", column = @Column(name = "qss_id"))
@NamedQuery(name = "Question.findQuestionByExamination", query = "select q from Question q where q.examination.id = :exm_id")
public class Question extends DomainObject {

    public static final String FIND_BY_EXAMINATION = "Question.findQuestionByExamination";

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exm_id")
    private Examination examination;

    @Column(name = "qss_text")
    private String text;

    @Column(name = "qss_description")
    private String description;

    @Column(name = "qss_weight")
    private BigDecimal weight;

    @Column(name = "qss_type")
    @Enumerated(value = EnumType.ORDINAL)
    private QuestionType type = QuestionType.SINGLE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Option> options = new HashSet<>(0);

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
