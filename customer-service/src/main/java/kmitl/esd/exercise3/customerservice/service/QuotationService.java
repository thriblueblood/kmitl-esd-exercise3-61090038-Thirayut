package kmitl.esd.exercise3.customerservice.service;

import kmitl.esd.exercise3.customerservice.model.Quotation;
import kmitl.esd.exercise3.customerservice.repo.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Quote Service = business logic for offerings
 */
@Service
public class QuotationService {
    Logger logger = LogManager.getLogger(QuotationService.class);

    @Autowired
    QuotationRepository quotationRepository; //Persistence for quotation

    /**
     * Get all quotations
     * @return list of all quotations
     */
    public List<Quotation> getAllQuotations(){
        List<Quotation> quotations = new ArrayList<>();
        quotationRepository.findAll().forEach(quote->quotations.add(quote));
        return quotations;
    }

    /**
     * getting a specific record
     */
    public Quotation getQuotationById(Long id){
        return quotationRepository.findById(id).get();
    }
    /**
     * deleting a specific id
     */
    public void delete(Long id){
        quotationRepository.deleteById(id);
    }
}
