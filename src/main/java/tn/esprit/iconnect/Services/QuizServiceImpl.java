package tn.esprit.iconnect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Repositories.QuizRepository;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    private QuizRepository quizRepository;


    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(int id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
      return   quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(int id, Quiz quiz) {
        Quiz quiz1=quizRepository.findById(id).orElse(null);
        if(quiz.getQuestion()!=null) quiz1.setQuestion(quiz.getQuestion());
       return quizRepository.save(quiz1);
    }

    @Override
    public void deleteQuiz(int id) {
        quizRepository.deleteById(id);
    }

    @Override
    public void deleteAllQuiz() {
        quizRepository.deleteAll();
    }
}
