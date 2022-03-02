package tn.esprit.iconnect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Entity.QuizQuestion;
import tn.esprit.iconnect.Entity.QuizReponses;
import tn.esprit.iconnect.Repositories.QuizQuestionRepository;
import tn.esprit.iconnect.Repositories.QuizReponsesRepository;
import tn.esprit.iconnect.Repositories.QuizRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService{
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuizReponsesRepository quizReponsesRepository;

    @Autowired
    private QuizRepository quizRepository;
    @Override
    @Transactional
    public List<QuizQuestion> addQuizQuestionAndAffecterToQuiz(QuizQuestion quizQuestion,
                                                                             List<Integer> quizReponses,
                                                                             int idQuiz) {
        Quiz quiz=quizRepository.findById(idQuiz).get();
        QuizQuestion quizQuestion1=quizQuestionRepository.save(quizQuestion);
        for(Integer q:quizReponses){
            QuizReponses qq=quizReponsesRepository.findById(q).get();
            qq.setQuizQuestion(quizQuestion1);
            quizReponsesRepository.save(qq);
        }
        quizQuestion1.setQuiz(quiz);
        quizQuestionRepository.save(quizQuestion1);
        return quizQuestionRepository.findAll();
    }

    @Override
    public List<QuizQuestion> getAllQuizQuestion() {
        return quizQuestionRepository.findAll();
    }

    @Override
    public QuizQuestion getQuizQuestionById(int id) {
        return quizQuestionRepository.findById(id).get();
    }

    @Override
    public QuizQuestion updateQuizQuestion(int id, QuizQuestion quizQuestion) {
        QuizQuestion quizQuestion1=this.getQuizQuestionById(id);
        if(quizQuestion.getQuestion()!=null)quizQuestion1.setQuestion(quizQuestion.getQuestion());
        if(quizQuestion.getQuiz()!=null)quizQuestion1.setQuiz(quizQuestion.getQuiz());
        if(quizQuestion.getQuizReponses()!=null)quizQuestion1.setQuizReponses(quizQuestion.getQuizReponses());
        return quizQuestionRepository.save(quizQuestion1);
    }

    @Override
    public void deleteQuizQuestionById(int id) {
        quizQuestionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
    quizQuestionRepository.deleteAll();
    }
}
