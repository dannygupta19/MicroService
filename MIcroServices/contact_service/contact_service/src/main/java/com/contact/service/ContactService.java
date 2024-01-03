package com.contact.service;

import com.contact.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContactsOfUser(Long userId);
    public void postContact(Contact contact);

}
