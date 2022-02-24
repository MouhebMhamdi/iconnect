package tn.esprit.iconnect.Services;

import tn.esprit.iconnect.Entity.Evaluation;
import tn.esprit.iconnect.Entity.Quiz;

import java.util.List;

public interface EvalutaionService {
    Evaluation getEvaluationByQuiz(int quiz);

    Evaluation addEvaluation(int quiz,Evaluation evaluation);
}
