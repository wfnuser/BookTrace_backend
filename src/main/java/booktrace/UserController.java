package booktrace;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wfnuser on 16/12/24.
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository userrepository;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Result signup(@RequestBody User user) {
        if (userrepository.findByUsername(user.username) == null) {
            userrepository.insert(user);
            return new Result(true);
        } else {
            return new Result(false);
        }
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public Result signin(@RequestBody User user) {
        User target = userrepository.findByUsername(user.username);
        if ( target != null) {
            if (target.password.equals(user.password))
                return new Result(true, target);
            else
                return new Result(false);
        } else {
            return new Result(false);
        }
    }

    @RequestMapping(value = "/mark", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public BookStatus mark(@RequestBody BookStatus bookstatus) {
        User targetUser = userrepository.findOne(bookstatus.userid);
        System.out.print(targetUser);
        targetUser.mark(bookstatus);
        userrepository.save(targetUser);
        return bookstatus;
    }


    @RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="World") String username) {
        return  userrepository.findByUsername(username);
    }


}
