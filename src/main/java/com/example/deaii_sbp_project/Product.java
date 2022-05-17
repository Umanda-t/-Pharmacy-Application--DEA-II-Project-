package com.example.deaii_sbp_project;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true,nullable = false, length = 30)
    private String name;

    @Column(name = "madein",nullable = false, length = 26)
    private String madein;

    @Column(name = "quantity", nullable = false, length = 20)
    private int quantity;

    @Column(name = "price", nullable = false, length = 80)
    private float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
