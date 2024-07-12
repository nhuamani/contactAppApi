package com.nhuamani.contactAppApi.service;

import com.nhuamani.contactAppApi.model.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAll();
    public Contact getById(Long id);
    public void save(Contact contact);
    public void update(Contact contact);
    public void delete(Long id);
}
