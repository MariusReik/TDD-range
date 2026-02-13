package org.example;

public final class Range<T extends Comparable<? super T>> {

    private final T low;
    private final T high;

    public Range(T low, T high) {
        if (low == null || high == null) throw new IllegalArgumentException();
        if (low.compareTo(high) >= 0) throw new IllegalArgumentException();
        this.low = low;
        this.high = high;
    }

    public boolean contains(T value) {
        if (value == null) return false;
        return low.compareTo(value) <= 0
                && value.compareTo(high) < 0;
    }

    public boolean overlaps(Range<T> other) {
        return this.low.compareTo(other.high) < 0
                && other.low.compareTo(this.high) < 0;
    }

    public boolean contains(Range<T> other) {
        return this.low.compareTo(other.low) <= 0
                && other.high.compareTo(this.high) <= 0;
    }

}
