package com.rtim.esse.controler;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rtim.esse.dto.CartDto;
import com.rtim.esse.dto.DictionaryDto;
import com.rtim.esse.dto.DocumentDto;
import com.rtim.esse.model.Sorter;
import com.rtim.esse.service.CartService;

@Controller
public class CartController {

    public static final String PAGE_ALL_CARTS = "all_carts";
    public static final String PAGE_CART = "cart";
    public static final String PAGE_CARTS_REDIRECT = "redirect:/";

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String getAllSortedCarts(@RequestParam Optional<Sorter> sort, CartDto cartDto, DocumentDto documentDto,
            DictionaryDto dictionaryDto, Model model) {
        String sortBy = sort.orElse(Sorter.NAME).getValue();
        model.addAttribute("allCarts", cartService.findAllCartsSortedBy(sortBy));
        return PAGE_ALL_CARTS;
    }

    @GetMapping("/carts/{id}")
    public String getCartById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cartDto", cartService.getCartById(id));
        return PAGE_CART;
    }

    @PostMapping("/carts/save")
    public String saveNewCart(CartDto cartDto) {
        cartService.createCart(cartDto);
        return PAGE_CARTS_REDIRECT;
    }

    @PatchMapping("/carts/update")
    public String updateCart(CartDto cartDto) {
        cartService.updateCart(cartDto);
        return PAGE_CARTS_REDIRECT;
    }

    @DeleteMapping("/carts/delete/{id}")
    public String deleteCartById(@PathVariable("id") Integer id) {
        cartService.deleteCartById(id);
        return PAGE_CARTS_REDIRECT;
    }
}