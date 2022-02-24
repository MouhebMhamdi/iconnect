package tn.esprit.iconnect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.iconnect.Entity.QuizReponses;
import tn.esprit.iconnect.Repositories.QuizRepository;
import tn.esprit.iconnect.Services.QuizReponse;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/quizReponse")
public class QuizReponseController {


    @Autowired
    private QuizReponse quizReponse;

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/findQuizReponse/{idQuiz}")
    public List<QuizReponses> getQuizReponseByQuiz(@PathVariable int idQuiz){
       return  quizReponse.getQuizReponseByQuiz(idQuiz);
    }

    @GetMapping("/correctAnswer/{idQuiz}")
    public List<QuizReponses> getCorrectAnswerByQuiz(@PathVariable int idQuiz){
       return  quizReponse.getCorrectAnsowerByQuiz(true,quizRepository.findById(idQuiz).get());
    }
    @PostMapping("/addQuizReponse/{idQuiz}")
    public Collection<QuizReponses> addQuizReponse(@RequestBody List<QuizReponses> quizReponses, @PathVariable int idQuiz){
        return  quizReponse.addQuizReponse(quizReponses,idQuiz);
    }
    @Transactional
    @DeleteMapping("/delete/{idquiz}")
     public List<QuizReponses> deleteQuizReponse(@PathVariable int idquiz){
        return quizReponse.deleteQuizReponseByQuiz(idquiz);
    }


}
