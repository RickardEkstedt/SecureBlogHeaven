package com.example.secureblogheaven.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 35, nullable = false)
    private String firstName;
    @Column(length = 25, nullable = false)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)

    private Address address;
    @Column(length = 35, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private Long phone;
    @Column(length = 10, nullable = false)
    private String memberType;

    public User() {
    }

    public User(Long id, String firstName, String lastName, Address address, String email, Long phone, String memberType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.memberType = memberType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
