package ua.com.clothes_shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.entity.NumberOfItems;
import ua.com.clothes_shop.entity.ShoppingCart;
import ua.com.clothes_shop.service.ShoppingCartService;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;



@Controller
@RequestMapping("/cart/{id}")
@SessionAttributes("shoppingCart")
public class ShoppingCartContrl {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String show(Model model, @PathVariable int id, Principal principal){	
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		if(id == 0){
			return "user-noCart";
		}		
		ShoppingCart cart = shoppingCartService.findOne(id);
		model.addAttribute("shoppingBag", cart);
		try{
			List<NumberOfItems>list = new ArrayList<>();
			List<ItemOfClothing>list2 = cart.getItemsOfClothing();
			for(ItemOfClothing itemOfClothing:list2){
				list.add(new NumberOfItems(itemOfClothing, shoppingCartService.getQuantity(cart.getId(), itemOfClothing.getId()),cart.getId()));
			}
			model.addAttribute("list", list);
		}catch(Exception e){
			return "user-emptyShoppingCart";
		}
		
		try{
			model.addAttribute("total", shoppingCartService.price(cart));
		}catch(Exception e){
			return "user-emptyShoppingCart";
		}
		return "user-shoppingCart";	
	}
	
	@GetMapping("/delete/{itemId}")
	public String delete(@PathVariable ("id") int cartId, @PathVariable ("itemId") int itemId){
		shoppingCartService.deleteItem(cartId, itemId);
		return "redirect:/cart/{id}";
	}
	
	@GetMapping("/minus/{itemId}")
	public String reduce(@PathVariable ("id") int cartId, @PathVariable ("itemId") int itemId){
		shoppingCartService.reduce(cartId, itemId);
		return "redirect:/cart/{id}";
	}
	
	@GetMapping("/plus/{itemId}")
	public String increase(@PathVariable ("id") int cartId, @PathVariable ("itemId") int itemId){
		shoppingCartService.increase(cartId, itemId);
		return "redirect:/cart/{id}";
	}
	

	
	

}
