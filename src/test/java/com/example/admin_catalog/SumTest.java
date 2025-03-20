package com.example.admin_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumTest {
    @Test
    void testSum() {
        Sum sum = new Sum();
        var actual = sum.sum(1, 2);
        var expected = 3;
        assertEquals(expected, actual);
    }
}
