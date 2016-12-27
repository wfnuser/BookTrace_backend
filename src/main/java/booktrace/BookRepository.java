package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findByTitleLike(String title);
    Book findByIsbn(String isbn);

    List<Book> findAllByTitleLike(String title);

}
