package tn.esprit.iconnect.Entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz_question")
@JsonRootName(value = "QuizQuestion")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String Question;

    @OneToMany(mappedBy = "quizQuestion",cascade = CascadeType.ALL)
    private List<QuizReponses> quizReponses;

    // this is a Bidirectionnel relation widh the Quiz entity
    @ToString.Exclude
    @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    private Quiz quiz;


}
