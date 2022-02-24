package tn.esprit.iconnect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.iconnect.Entity.Conseils;

@Repository
public interface ConseilsRepository extends JpaRepository<Conseils, Integer> {

}
