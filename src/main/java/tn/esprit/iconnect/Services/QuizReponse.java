package tn.esprit.iconnect.Services;

import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Entity.QuizReponses;

import java.util.Collection;
import java.util.List;

public interface QuizReponse {

QuizReponses addQuizReponse(QuizReponses quizReponse);
QuizReponses updateQuizReponse(int idQuizReponse ,QuizReponses quizReponses);
void deleteQuizRepById(int id);
void deleteAll();

List<QuizReponses> getAllQuizRep();



}
