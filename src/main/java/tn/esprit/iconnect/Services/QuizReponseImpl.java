package tn.esprit.iconnect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Entity.QuizReponses;
import tn.esprit.iconnect.Repositories.QuizReponsesRepository;
import tn.esprit.iconnect.Repositories.QuizRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class QuizReponseImpl implements QuizReponse {
    @Autowired
    private QuizReponsesRepository quizReponsesRepository;

    @Autowired
    QuizRepository quizRepository;


    @Override
    public QuizReponses addQuizReponse(QuizReponses quizReponse) {

        return quizReponsesRepository.save(quizReponse);
    }

    @Override
    public QuizReponses updateQuizReponse(int idQuizReponse, QuizReponses quizReponses) {
        QuizReponses quizReponses1=quizReponsesRepository.findById(idQuizReponse).get();
        if(quizReponses.getReponse()!=null) quizReponses1.setReponse(quizReponses.getReponse());
        if(quizReponses.getQuizQuestion()!=null)quizReponses1.setQuizQuestion(quizReponses.getQuizQuestion());
        if(quizReponses.getEvaluation()!=null)quizReponses1.setEvaluation(quizReponses.getEvaluation());
        return quizReponsesRepository.save(quizReponses1);
    }

    @Override
    public void deleteQuizRepById(int id) {
        quizReponsesRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
    quizReponsesRepository.deleteAll();
    }

    @Override
    public List<QuizReponses> getAllQuizRep() {
        return quizReponsesRepository.findAll();
    }
}
