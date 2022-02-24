package tn.esprit.iconnect.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.iconnect.Entity.Evaluation;
import tn.esprit.iconnect.Services.EvalutaionService;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Autowired
    private EvalutaionService evalutaionService;

    @GetMapping("/find/{id}")
    Evaluation  findEvaluationbyQuiz(@PathVariable int id){
        return evalutaionService.getEvaluationByQuiz(id);
    }



}
