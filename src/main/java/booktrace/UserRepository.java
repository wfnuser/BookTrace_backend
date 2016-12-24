package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);

}
