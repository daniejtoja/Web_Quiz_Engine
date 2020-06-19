package engine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionNotFound extends Exception {
    public QuestionNotFound(String errorMessage) {
        super(errorMessage);
    }
}
