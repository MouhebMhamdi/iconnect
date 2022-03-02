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

    @PostMapping("/add")
    public QuizReponses addquizReponses(@RequestBody QuizReponses quizReponses){
        return quizReponse.addQuizReponse(quizReponses);
    }

    @PutMapping("/update/{id}")
    public QuizReponses updateQuizRep(@RequestBody QuizReponses quizReponses,@PathVariable int id){
        return quizReponse.updateQuizReponse(id,quizReponses);
    }
    @GetMapping("/all")
    public List<QuizReponses> getAllQuizRep(){
        return quizReponse.getAllQuizRep();
    }
    @DeleteMapping("/{id}")
    public List<QuizReponses> deleteById(@PathVariable int id){
        quizReponse.deleteQuizRepById(id);
        return this.getAllQuizRep();
    }

    @DeleteMapping("/all")
    public String deleteAll(){
        quizReponse.deleteAll();
        return "All quiz reponse deleted";
    }

}
