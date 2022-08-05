package com.rtim.esse.dto;

import org.mapstruct.Mapper;
import com.rtim.esse.model.Cart;
import com.rtim.esse.model.Dictionary;
import com.rtim.esse.model.Document;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    CartDto cartToCartDto(Cart cart);

    Cart cartDtoToCart(CartDto cartDto);

    DictionaryDto dictionaryToDictionaryDto(Dictionary dictionary);

    Dictionary dictionaryDtoToDictionary(DictionaryDto dictionaryDto);

    DocumentDto documentToDocumentDto(Document document);

    Document documentDtoToDocument(DocumentDto documentDto);

}