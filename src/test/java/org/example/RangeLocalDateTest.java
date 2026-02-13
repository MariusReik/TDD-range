package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RangeLocalDateTest {

    @Test
    void lowIsIncluded_highIsExcluded() {
        LocalDate low = LocalDate.of(2026, 2, 1);
        LocalDate high = LocalDate.of(2026, 3, 1);

        Range<LocalDate> r = new Range<>(low, high);

        assertTrue(r.contains(LocalDate.of(2026, 2, 1)));
        assertTrue(r.contains(LocalDate.of(2026, 2, 28)));
        assertFalse(r.contains(LocalDate.of(2026, 3, 1)));
        assertFalse(r.contains(LocalDate.of(2026, 1, 31)));
    }

    @Test
    void invalidRange_throws() {
        LocalDate d = LocalDate.of(2026, 2, 1);
        assertThrows(IllegalArgumentException.class, () -> new Range<>(d, d));
    }
}
