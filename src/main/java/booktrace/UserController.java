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
    private UserRepository userrepository;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) {
        if (userrepository.findByUsername(user.username) == null) {
            return userrepository.insert(user);
        } else {
            return userrepository.findByUsername("");
        }
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public boolean signin(@RequestBody User user) {
        User target = userrepository.findByUsername(user.username);
        System.out.println(target.password);
        System.out.println(user.password);

        if ( target != null) {
            if (target.password.equals(user.password))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    @RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="World") String username) {
        return  userrepository.findByUsername(username);
    }


}
