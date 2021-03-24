package kmitl.esd.exercise3.customerservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO class for a customer (API gateway/API client)
 */
// @NoArgsConstructor
@Setter @Getter
public class CustomerDTO implements Serializable {
    private Long id; // defined unique id
    private String name; // defined  name of the customer
    private Long age; // defined age in years
    private String remark; // defined text for customer

    public CustomerDTO(){
        //
    }
    public CustomerDTO(long id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor for customer's DTO class
     * @param id
     * @param name
     * @param age
     * @return void
     */
    public CustomerDTO(long id, String name, long age){
        this(id, name);
        this.age = age;
    }

    /**
     * Function for printing a customer details
     * @return customer details in string format
     */
    public String toString(){
        return Long.toString(id) + ", " + name + ", " + age;
    }
}
