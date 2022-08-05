package com.rtim.esse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rtim.esse.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}