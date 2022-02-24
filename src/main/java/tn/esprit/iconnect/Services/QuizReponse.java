package tn.esprit.iconnect.Services;

import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Entity.QuizReponses;

import java.util.Collection;
import java.util.List;

public interface QuizReponse {

    List<QuizReponses> getQuizReponseByQuiz(int idquiz);

    List<QuizReponses> getCorrectAnsowerByQuiz(Boolean etat,Quiz quiz);

    Collection<QuizReponses> addQuizReponse(List<QuizReponses>  quizReponses, int id);


    List<QuizReponses> deleteQuizReponseByQuiz(int quiz);



}
