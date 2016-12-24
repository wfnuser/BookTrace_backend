package booktrace;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;

import java.util.List;

/**
 * Created by wfnuser on 16/12/24.
 */

public class Book {

    @Id
    public String id;

    public String title;
//    public String subtitle;
    public Author author;
    public String content;
    public List<Comment> comments;
    public double grade;



    public Book() {}

    public Book(String title, Author author, String content, List<Comment> comments, double grade) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.comments = comments;
        this.grade = grade;
    }



}