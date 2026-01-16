package kyu5.time;

public class TimeResult {
    private final int value;
    private final int remainder;

    public TimeResult(int value, int remainder) {
        this.value = value;
        this.remainder = remainder;
    }

    public int getValue() {
        return value;
    }

    public int getRemainder() {
        return remainder;
    }
}
