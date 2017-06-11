package ua.com.clothes_shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.entity.Orders;
import ua.com.clothes_shop.entity.User;
import ua.com.clothes_shop.service.ItemOfClothingService;
import ua.com.clothes_shop.service.OrdersService;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;
import ua.com.clothes_shop.validator.OrdersValidator;

@Controller
public class ItemContrl {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemOfClothingService itemOfClothingService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@Autowired
	private OrdersService ordersService;
	
	@InitBinder("orders")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new OrdersValidator(ordersService));
	}
	
	@GetMapping("/item/{id}")
	public String show(Model model, @PathVariable int id, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("itemOfClothing", itemOfClothingService.findOne(id));
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-item";
		
	}
	
	@GetMapping("/addToCart/{itemId}")
	public String addToCart(Principal principal, @PathVariable int itemId, Model model){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
 			String email = principal.getName();
 			User user = userService.findByEmail(email);
 			int userId = user.getId();
 			userService.addToShoppingCart(userId, itemId);
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
 		}
		else{
			model.addAttribute("itemOfClothing", itemOfClothingService.findOne(itemId));
			model.addAttribute("orders", new Orders());
			return "user-singleItemPurchase";
 		}		
		return "redirect:/cart/{shoppingCart}";
	}
	
	@GetMapping("/singleBuy/{itemId}")
	public String registration(Model model, Principal principal, @PathVariable int itemId){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("itemOfClothing", itemOfClothingService.findOne(itemId));
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		model.addAttribute("orders", new Orders());
		return "user-singleItemPurchase";
	}
	
	@PostMapping("/singleBuy/{itemId}")
	public String save(@ModelAttribute("orders") @Valid Orders orders,  BindingResult br, Model model, SessionStatus status, Principal principal, @PathVariable int itemId){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("itemOfClothing", itemOfClothingService.findOne(itemId));
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		if(br.hasErrors()) return "user-singleItemPurchase";
		List<ItemOfClothing> list = new ArrayList<>();
		list.add(itemOfClothingService.findOne(itemId));
		orders.setItemsOfClothing(list);
		orders.setQuantity(1);
		orders.setTotalPrice(itemOfClothingService.findOne(itemId).getPrice());
		ordersService.save(orders);
		status.setComplete();
		return "user-thanks";
	}

}
