package co.com.client.webproject.test.utils;

public enum Subject {

    CUSTOMERSERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private final String value;

    Subject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
