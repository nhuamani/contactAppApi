package com.nhuamani.contactAppApi.service;

import com.nhuamani.contactAppApi.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    public List<Contact> getAll();
    public Contact getById(UUID id);
    public Contact save(Contact contact);
    public Contact update(Contact contact);
    public void delete(UUID id);
}
