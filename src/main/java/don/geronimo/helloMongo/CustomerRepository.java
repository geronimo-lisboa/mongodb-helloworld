
package don.geronimo.helloMongo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
