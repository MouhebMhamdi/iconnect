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
public class Conseils {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idConseils;

    private String conseil;

    // this is a Bidirectionnel relation widh the Evaluation entity
    @OneToOne
    private Evaluation evaluation;

    @Enumerated(EnumType.STRING)
    private EvaluationMessage evaluationMessage;
}
