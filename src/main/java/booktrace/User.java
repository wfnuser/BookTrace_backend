package booktrace;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wfnuser on 16/12/24.
 */
public class User {

    @Id
    public String id;

    public String username;
    public String password;
    public List<BookStatus> books;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s', books='%s']",
                id, username, password, books);
    }

    public void mark(BookStatus bookStatus) {
        if (books != null) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).id.equals(bookStatus.id)) {
                    books.get(i).status = bookStatus.status;
                    return;
                }
            }
        } else {
            books = new ArrayList<>();
        }
        this.books.add(bookStatus);
    }

}

