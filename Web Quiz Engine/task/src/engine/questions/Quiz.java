package engine.questions;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

@Entity
@Table(name = "questions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String text;

    @Column(nullable = false)
    private String[] options;

    @Column(name = "answers", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long[] answer;

    public Quiz() {
    }

    public Quiz(@NotBlank String title, @NotBlank String text, String[] options, long[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long[] getAnswer() {
        return answer;
    }

    public void setAnswer(long[] answer) {
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer=" + Arrays.toString(answer) +
                '}';
    }

    public static boolean isValidQuestion(Quiz quiz) {
        if(quiz.getOptions() == null) {
            return false;
        } else if(quiz.getOptions().length < 2) {
            return false;
        } else if (quiz.getText().isEmpty()) {
            return false;
        } else if (quiz.getTitle().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
