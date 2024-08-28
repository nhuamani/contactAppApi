package com.nhuamani.contactAppApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "firstname", length = 50)
    private String firstName;
    @Column(name = "lastname", length = 50)
    private String lastName;
    @Column(nullable=false)
    private Boolean status;
    private String company;
    @Column(length = 18)
    private String phone;
    private LocalDate birthdate;
    @Column(unique = true, length = 50)
    private String email;
}