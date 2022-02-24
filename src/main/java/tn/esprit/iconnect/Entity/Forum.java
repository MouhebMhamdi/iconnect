package tn.esprit.iconnect.Entity;
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

public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idForum;

    private String Sujet;
    private String Description;

    // this is a Bidirectionnel relation widh the Forum entity
    @OneToMany(mappedBy = "forum",cascade = CascadeType.ALL)
    private List<Quiz> quiz;

}
