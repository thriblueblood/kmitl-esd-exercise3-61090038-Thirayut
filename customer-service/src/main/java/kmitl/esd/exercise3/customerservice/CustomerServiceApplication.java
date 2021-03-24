package kmitl.esd.exercise3.customerservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan(basePackages = {"kmitl.esd.exercise3.customerservice.model.Customer"})
public class CustomerServiceApplication {
    public static void main(String[] args) {
        /**
         * Entry point use spring framework to start the service
         * @param args
         */
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}