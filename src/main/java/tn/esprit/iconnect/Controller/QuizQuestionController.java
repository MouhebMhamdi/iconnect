package tn.esprit.iconnect.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.iconnect.Entity.QuizQuestion;
import tn.esprit.iconnect.Services.QuizQuestionService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/quizQestion")
public class QuizQuestionController {
    @Autowired
    private QuizQuestionService quizQuestionService;

    @PostMapping("addQuizQuestionAndListReponseAndAffecterToQuiz/{idQuiz}/{quizReponses}")
    @ApiOperation(value = "Add quiz question and affect him to list of quiz Reponses and affect quiz to quiz question")
    public List<QuizQuestion> addQuizQuestionAndAffecterToQuiz(@RequestBody QuizQuestion quizQuestion, @PathVariable List<Integer> quizReponses, @PathVariable int idQuiz){
       return quizQuestionService.addQuizQuestionAndAffecterToQuiz(quizQuestion,quizReponses,idQuiz);
    }


    @GetMapping("/all")
    public List<QuizQuestion> getAllQuizQuestion(){
        return quizQuestionService.getAllQuizQuestion();
    }

    @GetMapping("/{id}")
    public QuizQuestion getQuizQuestionById(@PathVariable int id){
        return quizQuestionService.getQuizQuestionById(id);
    }

    @PutMapping("/{id}")
    public QuizQuestion updateQuizQuestion(@PathVariable int id,@RequestBody QuizQuestion quizQuestion){
        return quizQuestionService.updateQuizQuestion(id,quizQuestion);
    }

    @DeleteMapping("/{id}")
    public List<QuizQuestion> deleteQuizQuestionById(@PathVariable int id){
        quizQuestionService.deleteQuizQuestionById(id);
        return this.getAllQuizQuestion();
    }


    @DeleteMapping("/all")
    public String deleteQuizQuestion(){
        quizQuestionService.deleteAll();
        return "all quiz reponses deleted";
    }
}
