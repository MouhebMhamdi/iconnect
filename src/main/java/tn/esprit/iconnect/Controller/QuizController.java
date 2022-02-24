package tn.esprit.iconnect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.iconnect.Entity.Quiz;
import tn.esprit.iconnect.Services.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/getAll")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/find/{id}")
    public Quiz getOneQuiz(@PathVariable int id){
        return quizService.getQuizById(id);
    }

    @PostMapping("/add")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @PutMapping("/update/{id}")
    public Quiz updateQuiz(@PathVariable int id,@RequestBody Quiz quiz){
        return  quizService.updateQuiz(id,quiz);
    }

    @DeleteMapping("/delete/{id}")
    public List<Quiz> deleteQuiz(@PathVariable int id){
        quizService.deleteQuiz(id);
        return this.getAllQuiz();
    }

    @DeleteMapping("/deleteAll")
    public List<Quiz> deleteAllQuiz(){
        quizService.deleteAllQuiz();
        return this.getAllQuiz();
    }


}
