package com.nhuamani.contactAppApi.service.implementation;

import com.nhuamani.contactAppApi.model.Contact;
import com.nhuamani.contactAppApi.repository.ContactRepository;
import com.nhuamani.contactAppApi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(UUID id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        Contact contact = null;
        if (optionalContact.isPresent()) {
            contact = optionalContact.get();
        } else {
            throw new RuntimeException("Contact not found for id : " + id);
        }
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public void delete(UUID id) {
        contactRepository.deleteById(id);
    }
}
