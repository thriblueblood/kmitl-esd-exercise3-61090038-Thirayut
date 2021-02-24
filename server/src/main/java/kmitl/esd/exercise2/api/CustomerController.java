
package kmitl.esd.exercise2.api;
import kmitl.esd.exercise2.model.CustomerDTO;
import kmitl.esd.exercise2.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Web service for customer CRUD operations
 * Produce endpoints as a part of the server API
 * Controller reacts to requests, controls the workflow, and gives a response
 * RESTful webservice -> HTTP method calls
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

//    private static List<CustomerDTO> customers = new ArrayList<>();
    /**
     * REST web service endpoint Read = find customer
     * GET (HTTP) method for finding all customer
     * Example: : http://localhost:8080/customer/findall
     * @return list of all customers
     */
    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomers() {
        return CustomerService.SINGLE_INSTANCE.getAllCustomers();// ToDo use customer service and DB
    }

    /**
     * Create a customer
     * @param customer as a request body
     * @return the customer's saved version
     */
    @PostMapping
    public CustomerDTO createCustomer(CustomerDTO customer){
            return CustomerService.SINGLE_INSTANCE.createCustomer(customer);
    }

    /**
     * Update a customer
     * @param customer
     * @return the new version of customer or null if not success
     */
    @PutMapping
    public CustomerDTO updateCustomer(CustomerDTO customer){
        return CustomerService.SINGLE_INSTANCE.updateCustomer(customer); // ToDo replace the existing customer

    }

    /**
     * Delete a customer
     * @param customerId (id of the customer)
     * @return true (if deleted), false(if not found)
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id") Long customerId){
   return CustomerService.SINGLE_INSTANCE.deleteCustomer(customerId);
    }
}