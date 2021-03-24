package kmitl.esd.exercise3.customerservice.web;

import kmitl.esd.exercise3.customerservice.model.Quotation;
import kmitl.esd.exercise3.customerservice.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * API for customers(RestController)
 */
@RestController
public class QuotationController {

    @Autowired
    QuotationService quotationService; // Business Logic

    @GetMapping("/quotation")
    private List<Quotation> getAllQuotation(){
        return quotationService.getAllQuotations();
    }

    @GetMapping("quotation/{id}")
    private Quotation getQuotation(@PathVariable("id") Long id){
        return quotationService.getQuotationById(id);
    }

    @GetMapping("quotation/{id}")
    private void deleteQuotation(@PathVariable("id") Long id){
        quotationService.delete(id);
    }
}
