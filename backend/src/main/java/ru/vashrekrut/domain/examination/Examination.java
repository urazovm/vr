package ru.vashrekrut.domain.examination;

import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "examinations")
@AttributeOverride(name = "id", column = @Column(name = "exm_id"))
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Examination.findExaminationByName", query = "SELECT e FROM Examination e WHERE e.name = :name")
public class Examination extends DomainObject {

    public static final String FIND_BY_NAME = "Examination.findExaminationByName";

    @Column(name = "exm_name")
    private String name;

    @Column(name = "exm_description")
    private String description;

    @Column(name = "exm_price")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination", cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
