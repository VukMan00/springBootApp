package rs.ac.bg.fon.pracenjepolaganja.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.bg.fon.pracenjepolaganja.entity.primarykeys.QuestionTestPK;

import java.io.Serializable;

@Entity
@Table(name="questiontest")
@Data
public class QuestionTest implements Serializable {

    @EmbeddedId
    protected QuestionTestPK questionTestPK;

    @Column(name="points")
    private Integer points;

    @JoinColumn(name = "questionId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;

    @JoinColumn(name = "testId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test test;

}