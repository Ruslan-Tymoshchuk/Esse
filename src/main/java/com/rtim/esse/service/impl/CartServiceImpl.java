package com.rtim.esse.service.impl;

import static org.springframework.data.domain.Sort.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort.Direction;
import com.rtim.esse.dto.CartDto;
import com.rtim.esse.dto.MapStructMapper;
import com.rtim.esse.model.Cart;
import com.rtim.esse.repository.CartRepository;
import com.rtim.esse.service.CartService;

@Service
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MapStructMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, MapStructMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public List<CartDto> findAllCartsSortedBy(String sotrtBy) {
        return cartRepository.findAll(by(Direction.ASC, sotrtBy)).stream().map(cartMapper::cartToCartDto).toList();
    }

    @Override
    public List<CartDto> findAllCarts() {
        return cartRepository.findAll().stream().map(cartMapper::cartToCartDto).toList();
    }

    @Override
    @Transactional
    public CartDto createCart(CartDto cartDto) {
        Cart cart = cartRepository.save(cartMapper.cartDtoToCart(cartDto));
        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public CartDto getCartById(Integer id) {
        return cartMapper.cartToCartDto(cartRepository.getById(id));
    }

    @Override
    @Transactional
    public void updateCart(CartDto cartDto) {
        cartRepository.save(cartMapper.cartDtoToCart(cartDto));
    }

    @Override
    @Transactional
    public void deleteCartById(Integer id) {
        cartRepository.deleteById(id);
    }
}