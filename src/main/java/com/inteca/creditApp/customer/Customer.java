package com.inteca.creditApp.customer;

import com.inteca.creditApp.credit.Credit;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer
{
    //kolumny
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @PESEL
    @Column(name = "pesel")
    private String pesel;

    //relacja encji CUSTOMER z encja CREDIT
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_credit", joinColumns=@JoinColumn(name="customerId"),inverseJoinColumns=@JoinColumn(name="creditId"))
    private List<Credit> credit = new ArrayList<>();

    //konstruktory
    public Customer() { }

    public Customer(String firstName, String surname, String pesel) {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                //", credit=" + credit +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /*public List<Credit> getCredit() {
        return credit;
    }*/


    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }
}