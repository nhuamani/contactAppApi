package com.nhuamani.contactAppApi.controller;

import com.nhuamani.contactAppApi.model.Contact;
import com.nhuamani.contactAppApi.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping ("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }

    @GetMapping ("/contacts/{id}")
    public Contact getContactById(@PathVariable("id") UUID id) {
        return contactService.getById(id);
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact) {
        contactService.create(contact);
        return contact;
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable UUID id, @RequestBody Contact newContact) {
        contactService.updateById(newContact, id);
        return newContact;
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable("id") UUID id) {
        contactService.deleteById(id);
    }
}
