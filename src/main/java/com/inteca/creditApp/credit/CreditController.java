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
        //String productName = "afaga";
        //int value = 1424;
        //Product product = new Product();
        //product.setProductName(productName);
        //product.setValue(value);
        //Customer customer = new Customer("", "", "");
        //creditRepository.save(credit);
        credit.setCustomer(customer);
        credit.setProduct(product);
        customerRepository.save(customer);
        productRepository.save(product);


        return creditRepository.save(credit);

        //creditRepository.save(credit);
        //productRepository.save(product);
        //customerRepository.save(customer);
        //return creditRepository.save(credit);
    }

/*
    @RequestMapping("new")
    public Credit create(
            @PathVariable String creditName,
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable String pesel,
            @PathVariable String productName,
            @PathVariable int value)
    {
        Customer customer = new Customer(name, surname, pesel);
        Product product = new Product(productName, value);
        customerRepository.save(customer);
        productRepository.save(product);
        Credit credit = new Credit(creditName, customer, product);
        return creditRepository.save(credit);
        //return credit;
    }*/
}
