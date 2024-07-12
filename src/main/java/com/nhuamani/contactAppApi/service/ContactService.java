package com.nhuamani.contactAppApi.service;

import com.nhuamani.contactAppApi.model.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();
    public Contact getByIdContact(Long id);
    public void saveContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(Long id);
}
