package com.example.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/get")
	public List<CartItem> getCartDetails() {
		System.out.println("Inside getCartDetails");
		return cartService.getCartDetails();
	}
	
	@GetMapping("/get/{id}")
	public List<CartItem> getCartDetails(@PathVariable int id) {
		System.out.println("Inside one getCartDetails");
		return cartService.getCartDetails(id);
	}
	
	@PostMapping("/add")
	public int addCartDetails(@RequestBody CartItem cartItem) {
		System.out.println("@@@ Inside add");
		return cartService.addCartDetails(cartItem);
	}
	
	@PutMapping("/update")
	public int updateCartDetails(@RequestBody CartItem cartItem) {
		return cartService.updateCartDetails(cartItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public int deleteCartItem(@PathVariable int id) {
		System.out.println("hi :" + id);
		return cartService.deleteCartItem(id);
	}
	
}