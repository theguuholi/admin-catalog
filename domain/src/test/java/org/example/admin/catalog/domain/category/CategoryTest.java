package org.example.admin.catalog.domain.category;

import org.example.admin.catalog.domain.exceptions.DomainExceptions;
import org.example.admin.catalog.domain.validation.handler.ThrowValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {
    @Test
    void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Movies";
        final var expectedDescription = "The most watched category";
        final var expectedIsActive = true;
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

    }
    @Test
    void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReturnError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainExceptions.class, () -> actualCategory.validate(new ThrowValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
    @Test
    void givenAnInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReturnError() {
        final String expectedName = "";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainExceptions.class, () -> actualCategory.validate(new ThrowValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
    @Test
    void givenAnInvalidLessThanThree_whenCallNewCategoryAndValidate_thenShouldReturnError() {
        final String expectedName = "fi ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should have between 3 and 255 chars";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainExceptions.class, () -> actualCategory.validate(new ThrowValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
    @Test
    void givenAnInvalidNamewithMoreThan255_whenCallNewCategoryAndValidate_thenShouldReturnError() {
        final var expectedName = "filjlksadf;jklsad;jklfsadjkldfjklsadfjklsadkjldf;klsad;fkjlsdaklf sakdlfkjsadjkl;f;kjlsadklfsadkjfkjsdakflsadkljfkjsa sadlkfjsadfkjl;sad;lkfjsajk; ldskljdfskjldfsklj;adsf;kjlf;jka;fsjdk;kdfsja;kjfds;jklfdsklj;fds;kjfdskjlfsadk;fds;kajlsf ldsjklfsdkljfdskljfdkljsfkljdskljfsdkljfjklsdkjlfsdkljfkljdsf";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should have between 3 and 255 chars";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainExceptions.class, () -> actualCategory.validate(new ThrowValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenAValidActiveCategory_whenCallDeactivate_thenReturnCategoryInactivated() {
        final var expectedName = "Name";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var updatedAt = aCategory.getUpdatedAt();

        Assertions.assertNull(aCategory.getDeletedAt());
        Assertions.assertTrue(aCategory.isActive());

        final var actualCategory = aCategory.deactivate();

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNotNull(actualCategory.getDeletedAt());
        Assertions.assertEquals(false, actualCategory.isActive());
    }

    @Test
    void givenAValidInActiveCategory_whenCallActivate_thenReturnCategoryActivated() {
        final var expectedName = "Name";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        var updatedAt = aCategory.getUpdatedAt();

        Assertions.assertNull(aCategory.getDeletedAt());
        Assertions.assertTrue(aCategory.isActive());

        final var inactiveCategory = aCategory.deactivate();


        Assertions.assertEquals(aCategory.getId(), inactiveCategory.getId());
        Assertions.assertEquals(expectedName, inactiveCategory.getName());
        Assertions.assertEquals(expectedDescription, inactiveCategory.getDescription());
        Assertions.assertNotNull(inactiveCategory.getCreatedAt());
        Assertions.assertTrue(inactiveCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNotNull(inactiveCategory.getDeletedAt());
        Assertions.assertFalse(inactiveCategory.isActive());

        updatedAt = inactiveCategory.getUpdatedAt();
        final var actualCategory = aCategory.activate();

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());
        Assertions.assertTrue(actualCategory.isActive());
    }

    @Test
    void givenAValidCategory_whenCallUpdate_thenReturnCategoryUpdated() {
        final var expectedName = "Name";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCategory =
                Category.newCategory("A new Film", expectedDescription, expectedIsActive);

        Assertions.assertDoesNotThrow(() -> aCategory.validate(new ThrowValidationHandler()));

        Assertions.assertEquals("A new Film", aCategory.getName());

        final var  createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdatedAt();

        final var actualCategory = aCategory.update(expectedName, "new Description", expectedIsActive);

        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals("new Description", actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());
        Assertions.assertTrue(actualCategory.isActive());
    }
}