package com.rtim.esse.dto;

import java.util.Objects;

public class CartDto {

    private Integer id;
    private DocumentDto document;
    private DictionaryDto dictionary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentDto getDocument() {
        return document;
    }

    public void setDocument(DocumentDto document) {
        this.document = document;
    }

    public DictionaryDto getDictionary() {
        return dictionary;
    }

    public void setDictionary(DictionaryDto dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictionary, document, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartDto other = (CartDto) obj;
        return Objects.equals(dictionary, other.dictionary) && Objects.equals(document, other.document)
                && Objects.equals(id, other.id);
    }
}