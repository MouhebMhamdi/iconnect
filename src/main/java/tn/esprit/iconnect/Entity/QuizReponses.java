package tn.esprit.iconnect.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;

@Entity
//I choose the lombok to generate the getter, setter and the constructors
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "QuizReponses")
public class QuizReponses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuizRep;
    private String reponse;
    private boolean etat;



    // this is a Bidirectionnel relation widh the Evaluation entity
    @OneToOne(mappedBy = "quiz",cascade = CascadeType.ALL)
    @JsonIgnore
    private Evaluation evaluation;

    @ManyToOne
    @JsonIgnore
    private QuizQuestion quizQuestion;
}
