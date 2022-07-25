package zw.co.msu.eSadza.controller;

import zw.co.msu.eSadza.service.CartService;
import zw.co.msu.eSadza.service.CartServiceImpl;
import zw.co.msu.eSadza.model.NewCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {

		this.cartService = cartService;
	}


	@PostMapping("/api/cart")
	public int getTotal(@RequestBody NewCart[] cart, Model model) {

		cartService.saveToCart(cart);
		return cartService.claculateTotal(cart);
	}

	@RequestMapping("/changeDB")
	public boolean changeDB() {

		cartService.updateDB();
		return true;
	}

	@PostMapping("/addToCart")
	public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model) {

		cartService.addItems(cart);
		return cart;
	}

	@PostMapping("/addNewItem")
	public boolean addNewItem(@RequestParam("file") MultipartFile file,
	                          @RequestParam("newFoodItem") String newFoodData) throws IOException {

		return cartService.addNewItem(file, newFoodData);
	}


	@PostMapping("/addNewItemUrl")
	public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {

		return cartService.addNewItemWithUrl(newFoodData);
	}

	@PostMapping("/checkItemId")
	public boolean checkItemId(@RequestBody String itemId, Model model) {

		return !cartService.itemIdAvailable(itemId);
	}
}
