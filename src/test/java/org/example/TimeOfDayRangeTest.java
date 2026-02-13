package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeOfDayRangeTest {

    @Test
    void meetingsOverlap_whenTheyShareTime() {
        Range<TimeOfDay> m1 = new Range<>(new TimeOfDay(9, 0), new TimeOfDay(10, 0));
        Range<TimeOfDay> m2 = new Range<>(new TimeOfDay(9, 30), new TimeOfDay(10, 30));

        assertTrue(m1.overlaps(m2));
        assertTrue(m2.overlaps(m1));
    }

    @Test
    void meetingsDoNotOverlap_whenTheyJustTouch() {
        Range<TimeOfDay> m1 = new Range<>(new TimeOfDay(9, 0), new TimeOfDay(10, 0));
        Range<TimeOfDay> m2 = new Range<>(new TimeOfDay(10, 0), new TimeOfDay(11, 0));

        assertFalse(m1.overlaps(m2));
        assertFalse(m2.overlaps(m1));
    }

    @Test
    void meetingContainsAnotherMeeting_whenFullyInside() {
        Range<TimeOfDay> longOne = new Range<>(new TimeOfDay(9, 0), new TimeOfDay(12, 0));
        Range<TimeOfDay> shortOne = new Range<>(new TimeOfDay(10, 0), new TimeOfDay(11, 0));

        assertTrue(longOne.contains(shortOne));
        assertFalse(shortOne.contains(longOne));
    }

    @Test
    void containsValue_lowIncluded_highExcluded() {
        Range<TimeOfDay> m = new Range<>(new TimeOfDay(9, 0), new TimeOfDay(10, 0));

        assertTrue(m.contains(new TimeOfDay(9, 0)));
        assertTrue(m.contains(new TimeOfDay(9, 59)));
        assertFalse(m.contains(new TimeOfDay(10, 0)));
    }
}
