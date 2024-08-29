package com.nhuamani.contactAppApi.controller;

import com.nhuamani.contactAppApi.model.Contact;
import com.nhuamani.contactAppApi.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") UUID id) {
        Optional<Contact> contact = Optional.ofNullable(contactService.getById(id));
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.create(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable UUID id, @RequestBody Contact newContact) {
        Contact newContactt = contactService.updateById(newContact, id);
        return ResponseEntity.ok(newContactt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") UUID id) {
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/vote/{id}/{rating}")
    public ResponseEntity<Contact> voteContact(@PathVariable UUID id, @PathVariable double rating) {
        Contact voted = contactService.getVoteRating(id, rating);
        return ResponseEntity.ok(voted);
    }
}
