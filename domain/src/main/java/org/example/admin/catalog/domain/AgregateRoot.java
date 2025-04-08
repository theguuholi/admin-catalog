package org.example.admin.catalog.domain;

public class AgregateRoot<ID extends Identifier> extends  Entity<ID>{
    protected AgregateRoot(ID id) {
        super(id);
    }
}
