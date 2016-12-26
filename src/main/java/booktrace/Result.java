package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */
public class Result {


    public boolean result;
    public User user;
    public double averageGrade;
    public double myGrade;

    public Result() {}

    public Result(boolean result) {
        this.result = result;
    }

    public Result(boolean result, User user) {
        this.result = result;
        this.user = user;
    }

    public Result(boolean result, double averageGrade, double myGrade) {
        this.result = result;
        this.averageGrade = averageGrade;
        this.myGrade = myGrade;
    }


}
