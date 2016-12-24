package booktrace;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wfnuser on 16/12/24.
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public User signin(@RequestBody User user) {
        return  repository.save(user);
    }

    @RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="World") String username) {
        return  repository.findByUsername(username);
    }


}
