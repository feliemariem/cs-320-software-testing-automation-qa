package edu.snhu.projectone.contacts;

import org.junit.jupiter.api.Test;

import edu.snhu.projectone.contacts.Contact;
import edu.snhu.projectone.contacts.ContactService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

/**
 * Unit tests for ContactService.
 * Tests adding, deleting, and updating contacts.
 */
class ContactServiceTest {

    @Test
    void addContact_succeeds_andDuplicateIdFails() {
        ContactService service = new ContactService();

        Contact c = service.addContact("1", "Anne", "Curtis", "2125557890", "New York");
        assertEquals("Anne", c.getFirstName());

        // duplicate ID should fail
        assertThrows(IllegalArgumentException.class,
            () -> service.addContact("1", "John", "Prats", "3105556789", "Los Angeles"));
    }

    @Test
    void deleteContact_succeeds_andMissingIdFails() {
        ContactService service = new ContactService();
        service.addContact("1", "Anne", "Curtis", "2125557890", "New York");

        // delete existing
        service.deleteContact("1");

        // deleting again should fail with the specific exception type
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("1"));
    }

    @Test
    void updateFields_byId_persists_andValidates() {
        ContactService service = new ContactService();
        service.addContact("1", "John", "Prats", "3105556789", "Los Angeles");

        // valid updates
        service.updateFirstName("1", "Anne");
        service.updateLastName("1", "Curtis");
        service.updatePhone("1", "2125557890");
        service.updateAddress("1", "New York");

        // read back and assert
        Contact updated = service.getForTest("1");
        assertEquals("Anne", updated.getFirstName());
        assertEquals("Curtis", updated.getLastName());
        assertEquals("2125557890", updated.getPhone());
        assertEquals("New York", updated.getAddress());

        // invalid input should fail validation
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "bad"));

        // updating a missing ID should fail
        assertThrows(NoSuchElementException.class, () -> service.updateAddress("missing", "Anywhere"));
    }
}
