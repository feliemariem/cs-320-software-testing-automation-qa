package edu.snhu.projectone.contacts;

public class Contact {

    // Fields
    private final String contactId;    // cannot change after creation
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Create a Contact and check all requirements.
     */
    public Contact(String contactId, String firstName,
                   String lastName, String phone, String address) {

        // contactId: required, max 10, not updatable
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be 1-10 characters");
        }
        this.contactId = contactId;

        // firstName and lastName: required, max 10
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be 1-10 characters");
        }
        this.firstName = firstName;

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be 1-10 characters");
        }
        this.lastName = lastName;

        // phone: exactly 10 digits
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;

        // address: required, max 30
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be 1-30 characters");
        }
        this.address = address;
    }

    // --- Getters ---
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    // --- Setters for allowed updates ---
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be 1-10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be 1-10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be 1-30 characters");
        }
        this.address = address;
    }
}
