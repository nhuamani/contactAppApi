package com.nhuamani.contactAppApi.service.implementation;

import com.nhuamani.contactAppApi.model.Contact;
import com.nhuamani.contactAppApi.repository.ContactRepository;
import com.nhuamani.contactAppApi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getByIdContact(Long id) {
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
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
