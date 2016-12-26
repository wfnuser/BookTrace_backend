package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */
public class Result {


    public boolean result;
    public User user;

    public Result() {}

    public Result(boolean result) {
        this.result = result;
    }

    public Result(boolean result, User user) {
        this.result = result;
        this.user = user;
    }



}
