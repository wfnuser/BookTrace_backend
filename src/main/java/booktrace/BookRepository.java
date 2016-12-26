package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;

public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitleLike(String title);

}
