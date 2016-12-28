package booktrace;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private UserRepository userrepository;


    @RequestMapping("/search")
    public List<Book> search(@RequestParam(value="title") String title) {
        return  bookrepository.findAllByTitleLike(title);
    }

    @RequestMapping("/book")
    public Book showBookInfo(@RequestParam(value="bookid") String bookid) {
        Book targetBook = bookrepository.findByIsbn(bookid);
        if (targetBook != null) {
            return targetBook;
        } else {
            List<Comment> comments = new ArrayList<>();
            Book newBook = new Book(null, new Author(null,null), null, comments, 9.9, bookid);
            return newBook;
        }

    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment addCommentToBook(@RequestBody Comment comment) {
        Book targetBook = bookrepository.findByIsbn(comment.bookId);
        if (targetBook != null) {
            targetBook.addCommentToBook(comment);
            bookrepository.save(targetBook);
        } else {
            List<Comment> comments = new ArrayList<>();
            bookrepository.save(new Book(null, new Author(null,null), null, comments, 9.9, comment.bookId));
            Book newBook = bookrepository.findByIsbn(comment.bookId);
            newBook.addCommentToBook(comment);
            bookrepository.save(newBook);
        }
        return comment;
//        return targetBook.addCommentToBook(comment);
    }

    @RequestMapping(value = "/grade", method = RequestMethod.POST)
    public BookStatus gradeBook(@RequestBody BookStatus bookStatus) {
        Book targetBook = bookrepository.findByIsbn(bookStatus.id);
        System.out.print(targetBook);
        System.out.print(bookStatus.id);
        if (targetBook != null) {
            targetBook.gradeBook(bookStatus);
            bookrepository.save(targetBook);
        } else {
            List<Comment> comments = new ArrayList<>();
            bookrepository.save(new Book(null, new Author(null,null), null, comments, 9.9, bookStatus.id));
            Book newBook = bookrepository.findByIsbn(bookStatus.id);
            newBook.gradeBook(bookStatus);
            bookrepository.save(newBook);
        }
        return bookStatus;
    }

    @RequestMapping(value = "/getgrade/{bookid}/{userid}")
    public Result getMyGrade(@PathVariable String bookid, @PathVariable String userid) {
        Book targetBook = bookrepository.findByIsbn(bookid);
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
                average = average / targetBook.grades.size();
            } else {
            }
            return new Result(true, average, mygrade);
        } else {
            return new Result(true, average, mygrade);
        }
    }

    @RequestMapping(value = "/getstatus/{bookid}/{userid}")
    public Result getMyStatus(@PathVariable String bookid, @PathVariable String userid) {
        User targetUser = userrepository.findOne(userid);
        String status = "none";
        if (targetUser != null) {
            if(targetUser.books != null) {
                for (BookStatus eachbook : targetUser.books
                        ) {
                    if (eachbook.id.equals(bookid)) {
                        status = eachbook.status;
                    }
                }
            } else {
            }
            return new Result(true, status);
        } else {
            return new Result(false);
        }
    }




}
