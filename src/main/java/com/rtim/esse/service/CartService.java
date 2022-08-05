package com.rtim.esse.service;

import java.util.List;
import com.rtim.esse.dto.CartDto;

public interface CartService {

     List<CartDto> findAllCartsSortedBy(String sortBy);
    
     List<CartDto> findAllCarts();
    
     CartDto createCart(CartDto cartDto);
    
     CartDto getCartById(Integer id);
     
     void updateCart(CartDto cartDto);
     
     void deleteCartById(Integer id);
         
}