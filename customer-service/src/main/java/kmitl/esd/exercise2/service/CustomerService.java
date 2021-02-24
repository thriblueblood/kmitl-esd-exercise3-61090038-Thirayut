package kmitl.esd.exercise2.service;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerService {

    /**
     * Singleton
     */
    public static final CustomerService SINGLE_INSTANCE = new CustomerService();
    private static List<CustomerDTO> customers = new ArrayList<>();

    /**
     * method for get customer service class
     * @return SINGLE_INSTANCE
     */
    public static CustomerService getInstance(){
        return SINGLE_INSTANCE;
    }

    //ToDo replace with connection to database
    static {
        CustomerDTO customerThri = new CustomerDTO(1L,"Thri",21L);
        customers.add(customerThri);
    }

    /**
     * REST web service endpoint Read = find customer
     * GET (HTTP) method for finding all customer
     * Example: : http://localhost:8080/customer/findall
     * @return list of all customers
     */
    public List<CustomerDTO> getAllCustomers() {
        return customers; // ToDo use customer service and DB
    }

    /**
     * Create a customer
     * @param customer as a request body
     * @return the customer's saved version
     */
    public CustomerDTO createCustomer(CustomerDTO customer){
        customers.add(customer);
        return customer;
    }

    /**
     * Update a customer
     * @param customer
     * @return the new version of customer or null if not success
     */
    public CustomerDTO updateCustomer(CustomerDTO customer){
        customers.add(customer); // ToDo replace the existing customer
        CustomerDTO customerToBeUpdated = customers.stream().filter(c->c.getId().equals(customer.getId()))
                .findFirst().get();
        if (customerToBeUpdated != null){ // if exists, then replace
            customers.remove(customerToBeUpdated);
        }else{
            return null;
        }
        customers.add(customer);
        return customer;
    }

    /**
     * Delete a customer
     * @param customerId (id of the customer)
     * @return true (if deleted), false(if not found)
     */
    public Boolean deleteCustomer(@PathVariable("id") Long customerId){
        CustomerDTO customerToBeDeleted = customers.stream().filter(c->c.getId().equals(customerId)).findFirst().get();
        if (customerToBeDeleted != null){
            customers.remove(customerToBeDeleted);
            return true;
        }else{
            return false;
        }
    }
}
