package co.com.client.webproject.test.utils;

public enum Waits {
    MIN_WAIT(2),
    SHORT_WAIT(5),
    MID_WAIT(10),
    LONG_WAIT(20);

    private final int value;

    Waits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
