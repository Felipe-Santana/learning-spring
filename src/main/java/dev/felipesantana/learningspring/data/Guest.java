package dev.felipesantana.learningspring.data;

import jakarta.persistence.*;

@Entity
@Table(name = "GUEST")
public class Guest {
    @Id
    @GeneratedValue
    @Column(name = "GUEST_ID")
    private long id;

    @Column(name = "FIRST_NAME", length = 64)
    private String firstName;

    @Column(name = "LAST_NAME", length = 64)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 64)
    private String emailAddress;

    @Column(name = "ADDRESS", length = 64)
    private String address;

    @Column(name = "COUNTRY", length = 32)
    private String country;

    @Column(name = "STATE", length = 12)
    private String state;

    @Column(name = "PHONE_NUMBER", length = 24)
    private String phoneNumber;
}
