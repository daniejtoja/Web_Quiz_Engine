package engine;
/*
import engine.answers.Answer;
import engine.exceptions.InvalidUser;
import engine.users.MyUserDetailsService;
import engine.users.User;
import engine.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;
    Answer answer = new Answer(true, "Success");

    public UserController() {
    }

    @PostMapping(value = "/api/register", consumes = "application/json")
    public Answer addUser(@RequestBody User user) throws InvalidUser {
        System.out.println(user.toString());
        ExampleMatcher emailMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("email", ignoreCase());



        if(!myUserDetailsService.userRepository.exists(Example.of(user, emailMatcher))) {
            if(User.isValidUser(user)) {
                userRepository.save(user);
                return answer.setBoth(true, "Succeeded");
            }
        }
            throw new InvalidUser("Bad request");

    }
}*/