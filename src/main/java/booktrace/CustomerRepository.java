package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByGender(String gender);
    public List<Customer> findByLastName(String lastName);

}
