package com.example.deaii_sbp_project;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "id",nullable = false, length = 45)
    private int id;
    @Column(name = "username",nullable = false,  length = 65)
    private String username;

    @Column(name = "Contactno",nullable = false, length = 12)
    private String Contactno;

    @Column(name = "address", nullable = false, length =500)
    private String address;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactno() {
        return Contactno;
    }

    public void setContactno(String contactno) {
        Contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
