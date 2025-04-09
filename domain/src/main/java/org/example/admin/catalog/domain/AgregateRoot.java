package org.example.admin.catalog.domain;

import org.example.admin.catalog.domain.validation.ValidationHandler;

public abstract class AgregateRoot<ID extends Identifier> extends  Entity<ID>{
    protected AgregateRoot(ID id) {
        super(id);
    }
}
