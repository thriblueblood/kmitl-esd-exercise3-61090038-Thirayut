package kmitl.esd.exercise3.customerservice.service;

import kmitl.esd.exercise3.customerservice.model.Customer;
import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for CustomerService testing
 */

class CustomerServiceTest {
    private CustomerService customerService = new CustomerService();

    /**
     * method for getting all customers's testing
     */
    @Test
    void getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomer();
        assertEquals(allCustomers.size(),1);
    }

    /**
     * method for creating customer's testing
     */
    @Test
    void createCustomer() {
//        customerService.createCustomer(new CustomerDTO(3L,"Pure",20L));
//        assertEquals(customerService.getAllCustomer().size(),2);
//        customerService.delete(3L);
    }

    /**
     * method for updating customer's testing
     */
    @Test
    void updateCustomer() {
//        CustomerDTO newCustomer = customerService.createCustomer(new CustomerDTO(3L,"Pure",20L));
//        newCustomer.setName("Pond");
//
//        CustomerDTO updateCustomer = customerService.saveOrUpdate(newCustomer);
//        assertEquals(updateCustomer.getName(),"Pond");
//        customerService.delete(3L);
    }

    /**
     * method for deleting customer's testing
     */
    @Test
    void deleteCustomer() {
        assertEquals(customerService.getAllCustomer().size(),1);
        customerService.delete(1L);
        assertEquals(customerService.getAllCustomer().size(),0);
//        customerService.createCustomer(new CustomerDTO(1L,"Thri", 21L));
    }
}