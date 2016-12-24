package booktrace;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wfnuser on 16/12/24.
 */

@RestController
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository repository;

    @RequestMapping("/signin")
    public User user(@RequestParam(value="name", defaultValue="World") String name) {
        return  repository.save(new User(name,"123"));
    }


}
