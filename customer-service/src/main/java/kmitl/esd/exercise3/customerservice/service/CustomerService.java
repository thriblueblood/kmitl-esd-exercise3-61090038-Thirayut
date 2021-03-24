package kmitl.esd.exercise3.customerservice.service;

import kmitl.esd.exercise3.customerservice.model.Customer;
import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import kmitl.esd.exercise3.customerservice.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository; //persistence for customer, object injection

    /**
     * Get all customers
     * @return list of all customers
     */
    public List<Customer> getAllCustomer(){
        List<Customer>customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    /**
     * get all customer with specific name
     * @param name of the customer
     * @return customer with the name
     */
    public List<Customer> getCustomer(String name){
        List<Customer> customers= new ArrayList<Customer>();
        customerRepository.findByNameOrderByName(name).forEach(customer->customers.add(customer));
        return customers;
    }
    
    //getting a specific record
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    /**
     * save or update (upsert) for customer object
     * @param customer to be updated or inserted
     */
    public void saveOrUpdate(Customer customer){
        customerRepository.save(customer);
    }

    //deleting a specific record
    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
