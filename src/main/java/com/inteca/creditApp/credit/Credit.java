package com.inteca.creditApp.credit;

import com.inteca.creditApp.customer.Customer;
import com.inteca.creditApp.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT")
public class Credit
{
    //pola encji
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditId;

    @Column(name = "creditName")
    private String creditName;

    //relacja encji CUSTOMER z encja CREDIT
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    //konstruktory
    public Credit(String creditName) {
        this.creditName = creditName;
    }

    public Credit() {
    }

    //toString()
    @Override
    public String toString() {
        return "Credit{" +
                "creditId=" + creditId +
                ", creditName='" + creditName + '\'' +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }

    //gettery i settery
    public Long getCreditId() {
        return creditId;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Customer getCustomer() {
        return customer;
    }

    /*
    public void setCustomer(Customer customer, String name, String surname, String pesel) {
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPesel(pesel);
    }
    */

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}