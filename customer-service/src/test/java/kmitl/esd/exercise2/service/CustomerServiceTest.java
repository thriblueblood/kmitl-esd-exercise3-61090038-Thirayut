package kmitl.esd.exercise2.service;

import kmitl.esd.exercise2.model.CustomerDTO;
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
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        assertEquals(allCustomers.size(),1);
    }

    /**
     * method for creating customer's testing
     */
    @Test
    void createCustomer() {
        customerService.createCustomer(new CustomerDTO(3L,"Pure",20L));
        assertEquals(customerService.getAllCustomers().size(),2);
        customerService.deleteCustomer(3L);
    }

    /**
     * method for updating customer's testing
     */
    @Test
    void updateCustomer() {
        CustomerDTO newCustomer = customerService.createCustomer(new CustomerDTO(3L,"Pure",20L));
        newCustomer.setName("Pond");

        CustomerDTO updateCustomer = customerService.updateCustomer(newCustomer);
        assertEquals(updateCustomer.getName(),"Pond");
        customerService.deleteCustomer(3L);
    }

    /**
     * method for deleting customer's testing
     */
    @Test
    void deleteCustomer() {
        assertEquals(customerService.getAllCustomers().size(),1);
        customerService.deleteCustomer(1L);
        assertEquals(customerService.getAllCustomers().size(),0);
        customerService.createCustomer(new CustomerDTO(1L,"Thri", 21L));
    }
}