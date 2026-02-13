package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RangeIntTest {

    @Test
    void lowIsIncluded_highIsExcluded() {
        RangeInt r = new RangeInt(5, 10);
        assertTrue(r.contains(5));
        assertTrue(r.contains(9));
        assertFalse(r.contains(10));
        assertFalse(r.contains(4));
    }

    @Test
    void invalidRange_lowEqualHigh_throws() {
        assertThrows(IllegalArgumentException.class, () -> new RangeInt(5, 5));
    }

    @Test
    void invalidRange_lowGreaterThanHigh_throws() {
        assertThrows(IllegalArgumentException.class, () -> new RangeInt(6, 5));
    }

    @Test
    void overlaps_whenTheyShareAtLeastOneValue() {
        assertTrue(new RangeInt(5, 10).overlaps(new RangeInt(9, 12)));
        assertTrue(new RangeInt(5, 10).overlaps(new RangeInt(5, 6)));
        assertTrue(new RangeInt(5, 10).overlaps(new RangeInt(6, 10)));
    }

    @Test
    void doesNotOverlap_whenTouchingAtBoundary() {
        assertFalse(new RangeInt(5, 10).overlaps(new RangeInt(10, 12)));
        assertFalse(new RangeInt(10, 12).overlaps(new RangeInt(5, 10)));
    }

    @Test
    void containsRange_whenFullyInside() {
        RangeInt outer = new RangeInt(5, 10);
        assertTrue(outer.contains(new RangeInt(5, 10)));  // equal counts as "contains"
        assertTrue(outer.contains(new RangeInt(6, 9)));
        assertFalse(outer.contains(new RangeInt(4, 9)));
        assertFalse(outer.contains(new RangeInt(6, 11)));
    }
}
