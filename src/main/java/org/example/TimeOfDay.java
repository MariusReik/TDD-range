package org.example;

public final class TimeOfDay implements Comparable<TimeOfDay> {

    private final int hour;
    private final int minute;

    public TimeOfDay(int hour, int minute) {
        if (hour < 0 || hour > 23) throw new IllegalArgumentException();
        if (minute < 0 || minute > 59) throw new IllegalArgumentException();
        this.hour = hour;
        this.minute = minute;
    }

    public int hour() {
        return hour;
    }

    public int minute() {
        return minute;
    }

    @Override
    public int compareTo(TimeOfDay other) {
        if (this.hour != other.hour) {
            return Integer.compare(this.hour, other.hour);
        }
        return Integer.compare(this.minute, other.minute);
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
