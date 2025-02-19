package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Double salary;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer",cascade= {CascadeType.ALL})
    private List<Account> accounts = new ArrayList<>();

    @OneToOne(cascade= {CascadeType.ALL}) //Customer silindiğinde Address de silinir
    @JoinColumn(name = "address_id") // Adresin customer tablosunda foreign key olarak yer alması
    private Address address;
}
