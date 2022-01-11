package co.com.client.webproject.test.utils;

public enum AlertMessages {

    CONTACT_US_SUCCESS("Your message has been successfully sent to our team."),
    EMPTY_CART("Your shopping cart is empty.");

    private final String value;

    AlertMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
