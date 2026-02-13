package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeOfDayTest {

    @Test
    void constructsValidTime() {
        TimeOfDay t = new TimeOfDay(10, 53);
        assertEquals(10, t.hour());
        assertEquals(53, t.minute());
    }

    @Test
    void invalidHour_throws() {
        assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(24, 0));
    }

    @Test
    void invalidMinute_throws() {
        assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(10, -1));
        assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(10, 60));
    }

    @Test
    void comparesByTime() {
        assertTrue(new TimeOfDay(9, 0).compareTo(new TimeOfDay(10, 0)) < 0);
        assertEquals(0, new TimeOfDay(10, 0).compareTo(new TimeOfDay(10, 0)));
        assertTrue(new TimeOfDay(10, 1).compareTo(new TimeOfDay(10, 0)) > 0);
    }
}
