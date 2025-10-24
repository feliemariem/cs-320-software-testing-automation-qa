package edu.snhu.projectone.contacts;

import java.util.Collection; // Improvement: added for getAllContacts()
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Manages contacts in memory.
 * Supports adding, deleting, and updating contacts by ID.
 */
public class ContactService {

    // Store contacts by their unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Add a new contact if the ID is unique.
     */
    public Contact addContact(String id, String first, String last, String phone, String address) {
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        Contact c = new Contact(id, first, last, phone, address);
        contacts.put(id, c);
        return c;
    }

    /**
     * Delete a contact by ID.
     */
    public void deleteContact(String id) {
        if (contacts.remove(id) == null) {
            throw new NoSuchElementException("No contact found with ID: " + id);
        }
    }

    /**
     * Update allowed fields of an existing contact.
     */
    public void updateFirstName(String id, String newFirst) {
        Contact c = getContact(id);
        c.setFirstName(newFirst);
    }

    public void updateLastName(String id, String newLast) {
        Contact c = getContact(id);
        c.setLastName(newLast);
    }

    public void updatePhone(String id, String newPhone) {
        Contact c = getContact(id);
        c.setPhone(newPhone);
    }

    public void updateAddress(String id, String newAddress) {
        Contact c = getContact(id);
        c.setAddress(newAddress);
    }

    /**
     * Helper: find a contact or throw an error if it doesn't exist.
     */
    private Contact getContact(String id) {
        Contact c = contacts.get(id);
        if (c == null) {
            throw new NoSuchElementException("No contact found with ID: " + id);
        }
        return c;
    }

    Contact getForTest(String id) {
        return getContact(id);
    }

    // Improvement: Added basic retrieval method 
    public Collection<Contact> getAllContacts() {
        return contacts.values();
    }
}
