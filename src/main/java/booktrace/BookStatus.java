package booktrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * Created by wfnuser on 16/12/24.
 */

public class BookStatus {

    public String id;
    public String userid;
    public String status;
    public Double grade;
    public String bookname;

    public BookStatus() {}

    public BookStatus(String isbn, String status, String userid, String bookname) {
        this.id = isbn;
        this.status = status;
        this.userid = userid;
        this.bookname = bookname;
    }

    public BookStatus(String isbn, Double grade, String userid) {
        this.id = isbn;
        this.grade = grade;
        this.userid = userid;
    }

}