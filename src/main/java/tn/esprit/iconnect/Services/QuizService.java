package tn.esprit.iconnect.Services;

import tn.esprit.iconnect.Entity.Quiz;

import java.util.List;

public interface QuizService {
    public List<Quiz> getAllQuiz();
    public Quiz getQuizById(int id);

    Quiz addQuiz(Quiz quiz);
    Quiz updateQuiz(int id,Quiz quiz);
    void deleteQuiz(int id);
    void deleteAllQuiz();


}
