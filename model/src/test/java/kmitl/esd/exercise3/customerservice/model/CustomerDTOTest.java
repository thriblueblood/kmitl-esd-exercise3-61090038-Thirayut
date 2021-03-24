package kmitl.esd.exercise3.customerservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for customerDTO testing
 */
class CustomerDTOTest {
    private CustomerDTO customer;
    /**
     * initialize a customer
     */
    @BeforeEach
    void setUp() {
        this.customer = new CustomerDTO(4L,"Pond",22L);
    }

    /**
     * method for id setting
     */
    @Test
    void setId() {
        this.customer.setId(5L);
        assertEquals(customer.getId(),5L);
    }

    /**
     * method for name setting
     */
    @Test
    void setName() {
        this.customer.setName("Pure");
        assertEquals(customer.getName(),"Pure");
    }

    /**
     * method for age setting
     */
    @Test
    void setAge() {
        this.customer.setAge(23L);
        assertEquals(customer.getId(),23L);
    }

    /**
     * method for id getting
     */
    @Test
    void getId() {
        assertEquals(customer.getId(),4L);
    }

    /**
     * method for name getting
     */
    @Test
    void getName() {
        assertEquals(customer.getName(),"Pond");
    }

    /**
     * method for age getting
     */
    @Test
    void getAge() {
        assertEquals(customer.getAge(),22L);
    }
}