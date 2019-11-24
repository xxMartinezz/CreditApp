package com.inteca.creditApp.product;

import com.inteca.creditApp.credit.Credit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    //pola dla encji
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "value")
    private int value;

    //relacja encji CUSTOMER z encja CREDIT
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private List<Credit> credit = new ArrayList<>();

    //konstruktory
    public Product(String productName, int value) {
        this.productName = productName;
        this.value = value;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                ", credit=" + credit +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Credit> getCredit() {
        return credit;
    }

    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }
}
