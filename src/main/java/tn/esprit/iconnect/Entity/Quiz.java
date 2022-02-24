package tn.esprit.iconnect.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
//I choose the lombok to generate the getter, setter and the constructors
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuiz;
    private String question;

    // this is a Bidirectionnel relation widh the quiz entity
    @ManyToOne
    private Forum forum;

    // this is a Bidirectionnel relation widh the QuizReponses entity
    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<QuizReponses> quizReponses;


}
