package edu.snhu.projectone.contacts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Contact.
 * Verifies all field rules: length limits, null checks, phone format,
 * and immutability of contactId.
 */
class ContactTest {

    @Test
    void validContactCreatesSuccessfully() {
        Contact c = new Contact("123", "Anne", "Curtis", "2125557890", "New York");
        assertEquals("Anne", c.getFirstName());
        assertEquals("123", c.getContactId());
    }

    // Improvement: Added boundary test for exactly allowed lengths
    @Test
    void boundaryLengthValuesStillValid() {
        String tenChars = "A".repeat(10);
        String thirtyChars = "B".repeat(30);
        Contact c = new Contact("1", tenChars, tenChars, "1234567890", thirtyChars);
        assertEquals(tenChars, c.getFirstName());
        assertEquals(thirtyChars, c.getAddress());
    }

    @Test
    void contactIdMustNotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "Anne", "Curtis", "2125557890", "New York"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("12345678901", "Anne", "Curtis", "2125557890", "New York"));
    }

    @Test
    void firstNameMustNotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", null, "Prats", "3105556789", "Los Angeles"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "ABCDEFGHIJK", "Prats", "3105556789", "Los Angeles"));
    }

    @Test
    void lastNameMustNotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "John", null, "3105556789", "Los Angeles"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "John", "ABCDEFGHIJK", "3105556789", "Los Angeles"));
    }

    @Test
    void phoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "Anne", "Curtis", "12345", "New York"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "Anne", "Curtis", "abcdefghij", "New York"));
    }

    @Test
    void addressMustNotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "Anne", "Curtis", "2125557890", null));
        String thirtyOneChars = "a".repeat(31);
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "Anne", "Curtis", "2125557890", thirtyOneChars));
    }

    @Test
    void settersWorkAndStillValidate() {
        Contact c = new Contact("1", "John", "Prats", "3105556789", "Los Angeles");
        c.setFirstName("Anne");
        c.setLastName("Curtis");
        c.setPhone("2125557890");
        c.setAddress("New York");
        assertEquals("Anne", c.getFirstName());
        assertEquals("Curtis", c.getLastName());
        assertEquals("2125557890", c.getPhone());
        assertEquals("New York", c.getAddress());

        // invalid updates should still fail
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("bad"));
    }
    @Test
    void ctor_acceptsBoundaryLengths_matchesStyle() {
        // Using exact boundary sizes for each field (all should be valid)
        String id10   = "1234567890";     // id = 10 chars (max)
        String first10 = "A".repeat(10);  // firstName = 10 chars (max)
        String last10  = "B".repeat(10);  // lastName = 10 chars (max)
        String addr30  = "C".repeat(30);  // address = 30 chars (max)

        Contact c = new Contact(id10, first10, last10, "2125557890", addr30);

        assertEquals(id10, c.getContactId());
        assertEquals(first10, c.getFirstName());
        assertEquals(last10, c.getLastName());
        assertEquals("2125557890", c.getPhone());
        assertEquals(addr30, c.getAddress());
    }

    @Test
    void phone_enforcesExactlyTenDigits_matchesStyle() {
        // Phone: reject wrong lengths and non-digit formats
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1", "Anne", "Curtis", "212555789", "New York"));      // 9 digits
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("2", "John", "Prats", "31055567890", "Los Angeles"));  // 11 digits
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("3", "Anne", "Curtis", "212-555-7890", "New York"));   // dashes present
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("4", "John", "Prats", "310555678a", "Los Angeles"));   // letter present

        // Exactly 10 digits is accepted
        Contact ok = new Contact("5", "Anne", "Curtis", "2125557890", "New York");
        assertEquals("2125557890", ok.getPhone());
    }

    @Test
    void settersRejectNullsAndTooLongs_matchesStyle() {
        // Start from a valid contact; each setter should still validate inputs
        Contact c = new Contact("X", "John", "Prats", "3105556789", "Los Angeles");

        // firstName invalid cases
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));          // null
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("Q".repeat(11)));// >10 chars

        // lastName invalid cases
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));           // null
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("W".repeat(11))); // >10 chars

        // phone invalid cases
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));              // null
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123456789"));       // 9 digits
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345678901"));     // 11 digits
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("abcdefghij"));      // non-digits

        // address invalid cases
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));            // null
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("Z".repeat(31)));  // >30 chars
    }

    @Test
    void contactIdRemainsImmutable_afterUpdates_matchesStyle() {
        // Confirm contactId never changes after object creation
        Contact c = new Contact("LOCKED", "John", "Prats", "3105556789", "Los Angeles");

        c.setFirstName("Anne");
        c.setLastName("Curtis");
        c.setPhone("2125557890");
        c.setAddress("New York");

        assertEquals("LOCKED", c.getContactId());
    }

    @Test
    void settersAcceptBoundaryLengths_matchesStyle() {
        // Setters should accept values at the exact upper limits
        Contact c = new Contact("ID10", "Anne", "Curtis", "2125557890", "NY");

        c.setFirstName("A".repeat(10));  // 10-char firstName
        c.setLastName("B".repeat(10));   // 10-char lastName
        c.setAddress("C".repeat(30));    // 30-char address
        c.setPhone("3105556789");        // 10-digit phone

        assertEquals("A".repeat(10), c.getFirstName());
        assertEquals("B".repeat(10), c.getLastName());
        assertEquals("C".repeat(30), c.getAddress());
        assertEquals("3105556789", c.getPhone());
    }
}
