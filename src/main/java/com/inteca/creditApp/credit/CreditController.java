package com.inteca.creditApp.credit;

import com.inteca.creditApp.customer.Customer;
import com.inteca.creditApp.customer.CustomerRepository;
import com.inteca.creditApp.exceptions.CreditsNotFoundException;
import com.inteca.creditApp.product.Product;
import com.inteca.creditApp.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credits")
public class CreditController
{
    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    //zwracanie listy kredytów
    @GetMapping("")
    public Page<Credit> findAll(Pageable pageable)
    {
        Page<Credit> credits = creditRepository.findAll(pageable);
        if(credits.isEmpty())
        {
            throw new CreditsNotFoundException("Brak kredytów w bazie");
        }
        else return credits;
    }

    //tworzenie nowego kredytu
    @PostMapping("/new")
    public Credit create(@RequestBody Credit credit, Customer customer, Product product)
    {
        credit.setCustomer(customer);
        credit.setProduct(product);
        customerRepository.save(customer);
        productRepository.save(product);
        return creditRepository.save(credit);
    }
}
