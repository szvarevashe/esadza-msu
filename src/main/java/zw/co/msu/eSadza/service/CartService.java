package zw.co.msu.eSadza.service;

import org.springframework.web.multipart.MultipartFile;
import zw.co.msu.eSadza.model.Cart;
import zw.co.msu.eSadza.model.NewCart;

import java.io.IOException;
import java.util.List;

public interface CartService {
	public void saveToCart(NewCart[] newCarts);
	public List<Cart> getAllCart();
	public void addItems(NewCart[] cart);
	public int claculateTotal(NewCart[] newCart);
	public void updateDB();
	public boolean addNewItem(MultipartFile file, String newFoodData) throws IOException;
	public boolean addNewItemWithUrl(String newFoodData) throws IOException;
	public boolean itemIdAvailable(String itemId);

}
