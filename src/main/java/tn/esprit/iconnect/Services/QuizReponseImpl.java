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
    public List<QuizReponses> getQuizReponseByQuiz(int idquiz) {
        Quiz q=quizRepository.findById(idquiz).get();
        return quizReponsesRepository.getQuizReponsesByQuiz(q);
    }

    @Override
    public List<QuizReponses> getCorrectAnsowerByQuiz(Boolean etat, Quiz quiz) {
        return quizReponsesRepository.getQuizReponsesByEtatAndQuiz(true,quiz);
    }

    @Override
    public Collection<QuizReponses> addQuizReponse(List<QuizReponses> quizReponses, int id) {

        for (QuizReponses q:quizReponses) {
            q.setQuiz(quizRepository.findById(id).get());
            quizReponsesRepository.save(q);
        }
        return quizReponsesRepository.findAll();
    }




    @Override
    public List<QuizReponses> deleteQuizReponseByQuiz(int idquiz) {
        return quizReponsesRepository.deleteAllByQuiz(quizRepository.findById(idquiz).get());
    }
}
