package tn.esprit.iconnect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Entity.QuizReponses;

import java.util.List;

@Repository
public interface QuizReponsesRepository extends JpaRepository<QuizReponses, Integer> {
}
