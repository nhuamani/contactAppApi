package com.nhuamani.contactAppApi.service;

import com.nhuamani.contactAppApi.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    public List<Contact> getAll();
    public Contact getById(UUID id);
    public Contact create(Contact contact);
    public Contact updateById(Contact newContact, UUID id);
    public void deleteById(UUID id);
    public Contact getVoteRating(UUID id, Double rating);
}
