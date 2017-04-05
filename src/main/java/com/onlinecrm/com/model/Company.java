package com.onlinecrm.com.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Андрей on 04.04.2017.
 */
@Entity
@Table(name="Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "joiningDate", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;

    @Column(name = "nameChief", nullable = false)
    private String nameChief;

    @Column(name = "surnameChief", nullable = false)
    private String surnameChief;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", unique = true, nullable = false)
    private Address address;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "TIN", unique = true, nullable = false)
    private String TIN;

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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getNameChief() {
        return nameChief;
    }

    public void setNameChief(String nameChief) {
        this.nameChief = nameChief;
    }

    public String getSurnameChief() {
        return surnameChief;
    }

    public void setSurnameChief(String surnameChief) {
        this.surnameChief = surnameChief;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (!TIN.equals(company.TIN)) return false;
        if (!address.equals(company.address)) return false;
        if (!joiningDate.equals(company.joiningDate)) return false;
        if (!name.equals(company.name)) return false;
        if (!nameChief.equals(company.nameChief)) return false;
        if (!password.equals(company.password)) return false;
        if (!surnameChief.equals(company.surnameChief)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return TIN.hashCode();
    }
}
