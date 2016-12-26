package booktrace;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by wfnuser on 16/12/24.
 */

@RestController
public class BookController {

    @Autowired
    private BookRepository bookrepository;
    @Autowired
    private BookRepository userrepository;


    @RequestMapping("/search")
    public List<Book> search(@RequestParam(value="title") String title) {
        return  bookrepository.findAllByTitleLike(title);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment addCommentToBook(@RequestBody Comment comment) {
        Book targetBook = bookrepository.findOne(comment.bookId);
        System.out.println(comment.bookId);
        System.out.println(targetBook);
        targetBook.addCommentToBook(comment);
        bookrepository.save(targetBook);
        return comment;
//        return targetBook.addCommentToBook(comment);
    }

    @RequestMapping(value = "/grade", method = RequestMethod.POST)
    public BookStatus gradeBook(@RequestBody BookStatus bookStatus) {
        Book targetBook = bookrepository.findOne(bookStatus.id);
        if (targetBook != null) {
            targetBook.gradeBook(bookStatus);
            bookrepository.save(targetBook);
        }
        return bookStatus;
    }

    @RequestMapping(value = "/getgrade/{bookid}/{userid}")
    public Result getMyGrade(@PathVariable String bookid, @PathVariable String userid) {
        Book targetBook = bookrepository.findOne(bookid);
        double mygrade = 0.0;
        double average = 0.0;
        if (targetBook != null) {
            if(targetBook.grades != null) {
                for (BookStatus eachbook : targetBook.grades
                        ) {
                    if (eachbook.userid.equals(userid)) {
                        mygrade = eachbook.grade;
                    }
                    average = average + eachbook.grade;
                }
            } else {
            }
            return new Result(true, average, mygrade);
        } else {
            return new Result(false);
        }
    }




}
