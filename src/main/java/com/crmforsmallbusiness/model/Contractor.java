package com.crmforsmallbusiness.model;

import javax.persistence.*;

/**
 * Created by Андрей on 21.03.2017.
 */
@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "TIN", nullable = false)
    private int TIN;

    @Column(name = "USREOU", nullable = false)
    private int USREOU;

    @Column(name = "", nullable = false)
    private String email;

    public Contractor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public int getUSREOU() {
        return USREOU;
    }

    public void setUSREOU(int USREOU) {
        this.USREOU = USREOU;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", TIN=" + TIN +
                ", USREOU=" + USREOU +
                ", email='" + email + '\'' +
                '}';
    }
}
