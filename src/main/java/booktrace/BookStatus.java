package booktrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by wfnuser on 16/12/24.
 */

public class BookStatus {

    public String id;
    public String userid;
    public String status;
    public Integer grade;

    public BookStatus() {}

    public BookStatus(String id, String status, String userid) {
        this.id = id;
        this.status = status;
        this.userid = userid;
    }

    public BookStatus(String id, Integer grade, String userid) {
        this.id = id;
        this.grade = grade;
        this.userid = userid;
    }

}