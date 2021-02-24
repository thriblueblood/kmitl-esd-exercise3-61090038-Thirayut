package kmitl.esd.exercise2.api;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class for CustomerController testing
 */
class CustomerControllerTest {

    private CustomerController customerController = new CustomerController();

    /**
     * method for getting all customers's testing
     */
    @Test
    void getAllCustomers() {
        List<CustomerDTO> allCustomers = customerController.getAllCustomers();
        assertEquals(allCustomers.size(),1);
    }

    /**
     * method for creating customer's testing
     */
    @Test
    void createCustomer() {
        customerController.createCustomer(new CustomerDTO(3L,"Pure",20L));
        assertEquals(customerController.getAllCustomers().size(),2);
        customerController.deleteCustomer(3L);
    }

    /**
     * method for updating customer's testing
     */
    @Test
    void updateCustomer() {
        CustomerDTO newCustomer = customerController.createCustomer(new CustomerDTO(3L,"Pure",20L));
        newCustomer.setName("Pond");

        CustomerDTO updateCustomer = customerController.updateCustomer(newCustomer);
        assertEquals(updateCustomer.getName(),"Pond");
        customerController.deleteCustomer(3L);

    }

    /**
     * method for deleting customer's testing
     */
    @Test
    void deleteCustomer() {
        assertEquals(customerController.getAllCustomers().size(),1);
        customerController.deleteCustomer(1L);
        assertEquals(customerController.getAllCustomers().size(),0);
        customerController.createCustomer(new CustomerDTO(1L,"Thri", 21L));
    }
}