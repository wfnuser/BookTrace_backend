package booktrace;


/**
 * Created by wfnuser on 16/12/24.
 */

public class Comment {

    public String id;

    public String content;
    public String username;
    public String bookId;

    public Comment() {}

    public Comment(String content, String username) {
        this.content = content;
        this.username = username;
    }

    public Comment(String content, String username, String bookId) {
        this.content = content;
        this.username = username;
        this.bookId = bookId;
    }



}