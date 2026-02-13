package org.example;

public final class RangeInt {
    private final Range<Integer> range;

    public RangeInt(int low, int high) {
        this.range = new Range<>(low, high);
    }

    public boolean contains(int value) {
        return range.contains(value);
    }

    public boolean overlaps(RangeInt other) {
        return range.overlaps(other.range);
    }

    public boolean contains(RangeInt other) {
        return range.contains(other.range);
    }
}
