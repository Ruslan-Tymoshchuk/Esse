package com.rtim.esse.model;

public enum Sorter {

    NAME("Dictionary.name"), DATE("Document.date");

    private String value;

    Sorter(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}