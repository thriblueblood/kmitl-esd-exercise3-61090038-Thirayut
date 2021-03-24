package kmitl.esd.exercise3.customerservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Customer entity for persistence
 * Javax presistence -> JPA -> Impl.: Hibernate -> Spring JPA includes Hibernate
 */
@Entity
@Table //class name is table name
//@Table(name="customerTable")  //  table name in the DB is
@NoArgsConstructor //lombok create constructor with no arg
@Getter @Setter // lombok: getter and setter for all properties
public class Customer {

    @Id //primary key in DB
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id ;// id is primary key

    @Column @NonNull @Size(min=3,max=240)
    private String name; //customer name

    @Transient //value will not be saved in the DB
    private String tempRemark;

    @Column @Min(18) @Max(120)
    private Integer age; //age in years

    @Column @Pattern(regexp="\\(?\\d{0,3}\\)?\\d{3}-\\d{4}") //test with https://regexr.com/
    private String phoneNumber; //customer's main email address

    @Column @Pattern(regexp = ".*@.*\\..*")
    private String email;

    @Column @Past
    private LocalDateTime creationDateTime;

    @OneToMany
    protected List<Quotation> quotationList;
    /**
     * Constructor with main customer data
     * @param id customer id
     * @param name name of the customer
     * @param age age in years
     */

    public Customer(Long id,String name,Integer age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    /**
     * constructor with customer data:name and age
     * @param name name of the customer
     * @param age age in years
     */
    public Customer(String name,int age){
        this.name=name;
        this.age=age;
    }
}