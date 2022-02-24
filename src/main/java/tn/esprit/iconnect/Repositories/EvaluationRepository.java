package tn.esprit.iconnect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.iconnect.Entity.Evaluation;
import tn.esprit.iconnect.Entity.Quiz;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

    Evaluation getEvaluationByQuiz(Quiz quiz);
    List<Evaluation> deleteAllByQuiz(Quiz quiz);
}
