package kmitl.esd.exercise3.customerservice.model;

import com.sun.istack.NotNull;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Quote entity for persistence
 */
@Entity
@Table //class name is table name
//@NamedQuery(name="Quotation.findAll")

public class Quotation {
    @Id
    @Column
    private Long id;

    @Column @NotNull @Size(min=3,max=240)
    private String reference;

    @ManyToOne
    private Customer customer;

    @NotNull @Min(0)
    private Float price;

    @Column @Past
    private LocalDateTime creationDateTime;

    @Column @Future
    private LocalDateTime validUnitDateTime;

    @Column
    private LocalDateTime saveDateTime;

}
