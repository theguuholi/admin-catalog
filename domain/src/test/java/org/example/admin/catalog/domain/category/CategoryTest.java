package org.example.admin.catalog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {
    @Test
    void testNewCategory() {
        assertNotNull(new Category());
    }
}
