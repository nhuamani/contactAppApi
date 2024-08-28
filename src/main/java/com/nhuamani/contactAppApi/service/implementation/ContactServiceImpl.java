package com.nhuamani.contactAppApi.service.implementation;

import com.nhuamani.contactAppApi.exception.ContactNotFoundException;
import com.nhuamani.contactAppApi.model.Contact;
import com.nhuamani.contactAppApi.repository.ContactRepository;
import com.nhuamani.contactAppApi.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

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
    public Contact create(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public Contact updateById(Contact newContact, UUID id) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setFirstName(newContact.getFirstName());
                    contact.setLastName(newContact.getLastName());
                    contact.setStatus(newContact.getStatus());
                    contact.setCompany(newContact.getCompany());
                    contact.setPhone(newContact.getPhone());
                    contact.setBirthdate(newContact.getBirthdate());
                    contact.setEmail(newContact.getEmail());
                    return contactRepository.save(contact);
                })
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id " + id));
    }

    @Override
    public void deleteById(UUID id) {
        contactRepository.deleteById(id);
    }
}
