package org.example.admin.catalog.domain.category;

import org.example.admin.catalog.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {
    Category create(Category aCategory);
    Category update(Category aCategory);
    void deleteById(CategoryID anId);
    Optional<Category> findById(CategoryID anId);
    Pagination<Category> findAll(CategorySearchQuery query);
}
