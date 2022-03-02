package tn.esprit.iconnect.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//I choose the lombok to generate the getter, setter and the constructors
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvaluation;

    private int note;

    // this is a Bidirectionnel relation widh the Quiz entity
    @OneToOne
    private Quiz quiz;

    // this is a Bidirectionnel relation widh the Quiz entity
    @OneToOne(mappedBy = "evaluation",cascade = CascadeType.ALL)
      Conseils conseils;
}
