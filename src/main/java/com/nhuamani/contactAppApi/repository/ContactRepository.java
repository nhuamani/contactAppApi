package com.nhuamani.contactAppApi.repository;

import com.nhuamani.contactAppApi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
    Contact findByEmail(String email);
    List<Contact> findByCompany(String company);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
    void deleteByEmail(String email);

    // You can add more methods based on your specific use cases.
}
