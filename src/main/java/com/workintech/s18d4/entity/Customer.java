package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private double salary;

    @OneToOne(cascade = {CascadeType.ALL}) //Customer silindiğinde Address de silinir
    @JoinColumn(name = "address_id", nullable = true) // Adresin customer tablosunda foreign key olarak yer alması
    private Address address;
}
