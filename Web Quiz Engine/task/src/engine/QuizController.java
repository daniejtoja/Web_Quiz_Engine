package engine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import engine.questions.*;
import engine.answers.*;
import engine.exceptions.*;


import java.util.Arrays;
import java.util.List;


@RestController
public class QuizController {

    @Autowired
    private QuestionRepository questions;
    private Answer ans = new Answer(true);



    public QuizController(){ }


    @PostMapping(value = "/api/quizzes/{id}/solve", consumes = "application/json" )
    public Answer answerTheQuiz(@PathVariable("id") long id, @RequestBody ParseAnswer answer) throws QuestionNotFound{
        if(!questions.existsById(id)) {
            throw new QuestionNotFound("Not found");
        }


        long[] empty = {};
        long[] rightAnswer = questions.getOne(id).getAnswer() == null ? new long[] {} : questions.getOne(id).getAnswer();
        System.out.println(questions.getOne(id));
        long[] providedAnswer = answer.getAnswer() == null ? new long[] {} : answer.getAnswer();

        return ans.setSuccess(Arrays.equals(rightAnswer, providedAnswer));
    }

    @PostMapping(value = "/api/quizzes", consumes = "application/json")
    public Quiz addQuestion(@RequestBody Quiz question) throws BadQuestion{
        if(!Quiz.isValidQuestion(question)) {
            throw new BadQuestion("Bad request");
        } else {
            return questions.save(question);

        }

    }


    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz getQuestion(@PathVariable Long id) throws QuestionNotFound{

        if(!questions.existsById(id)) {
            throw new QuestionNotFound("Not found");
        } else {
            return questions.getOne(id);
        }
    }


    @GetMapping(path = "/api/quizzes")
    public List<Quiz> getAllQuestions() { return questions.findAll(); }

}
