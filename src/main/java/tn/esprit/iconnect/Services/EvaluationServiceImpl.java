package tn.esprit.iconnect.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.iconnect.Entity.Evaluation;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Repositories.EvaluationRepository;
import tn.esprit.iconnect.Repositories.QuizRepository;

import java.util.List;

@Service
public class EvaluationServiceImpl implements  EvalutaionService{

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Evaluation getEvaluationByQuiz(int quiz) {
        return evaluationRepository.getEvaluationByQuiz(quizRepository.findById(quiz).get());
    }

    @Override
    public Evaluation addEvaluation(int quiz, Evaluation evaluation) {
        Evaluation eval=evaluationRepository.save(evaluation);
        eval.setQuiz(quizRepository.findById(quiz).get());
        return evaluationRepository.save(eval);
    }


}
