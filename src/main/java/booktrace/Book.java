package booktrace;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wfnuser on 16/12/24.
 */

public class Book {

    @Autowired
    private BookRepository bookRepository;

    @Id
    public String id;

    public String title;
    public String isbn;
//    public String subtitle;
    public Author author;
    public String content;
    public List<Comment> comments;
    public double grade;
    public List<BookStatus> grades;

    public Book() {}

    public Book(String title, Author author, String content, List<Comment> comments, double grade, String isbn) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.comments = comments;
        this.grade = grade;
        this.isbn = isbn;
    }

    public void addCommentToBook(Comment comment) {
        if (this.comments != null) {

        } else {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
    }

    public void gradeBook (BookStatus bookStatus) {
        if (this.grades != null) {
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).id.equals(bookStatus.id)) {
                    grades.remove(i);
                }
            }
        } else {
            this.grades = new ArrayList<>();
        }
        this.grades.add(bookStatus);
    }


}