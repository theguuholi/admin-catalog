package org.example.admin.catalog.infrastructure;

import org.example.admin.catalog.application.UseCase;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!!");
        System.out.println(new UseCase().execute());
    }
}