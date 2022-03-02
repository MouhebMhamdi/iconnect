package tn.esprit.iconnect.Services;

import tn.esprit.iconnect.Entity.QuizQuestion;
import tn.esprit.iconnect.Entity.QuizReponses;

import java.util.List;

public interface QuizQuestionService {
    List<QuizQuestion> addQuizQuestionAndAffecterToQuiz(QuizQuestion quizQuestion, List<Integer> quizReponses,int idQuiz);
    List<QuizQuestion> getAllQuizQuestion();
    QuizQuestion getQuizQuestionById(int id);

    QuizQuestion updateQuizQuestion(int id,QuizQuestion quizQuestion);

    void deleteQuizQuestionById(int id);

    void deleteAll();

}
