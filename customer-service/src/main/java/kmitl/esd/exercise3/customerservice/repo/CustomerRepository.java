package kmitl.esd.exercise3.customerservice.repo;
import kmitl.esd.exercise3.customerservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Persistence for customers
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    /**
     * Find customers by name and ordered by name
     * ??? exact match or like name ???
     * @param name of customers to find
     * @return customers with the name or empty list
     */
    List<Customer> findByNameOrderByName(String name);

    List<Customer> findyNameOrderByAge(String name);
    List<Customer> findByNameAndAgeOOrderById(String id, Integer age);
}
